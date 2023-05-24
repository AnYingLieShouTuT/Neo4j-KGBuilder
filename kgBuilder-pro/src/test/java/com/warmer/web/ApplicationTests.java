package com.warmer.web;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.warmer.base.util.Neo4jUtil;
import com.warmer.web.entity.KgDomain;
import com.warmer.web.service.KgGraphService;
import com.warmer.web.service.KnowledgeGraphService;
import com.warmer.web.utils.TraverseJSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private KgGraphService kgGraphService;
    @Autowired
    private KnowledgeGraphService kgService;

    @Test
    void contextLoads() {
        List<KgDomain> domains = kgService.getDomains();
        int i = 0;
        if (domains != null && domains.size() > 0) {
            List<HashMap<String, Object>> graphIndex = Neo4jUtil.getGraphIndex();
            for (KgDomain domainItem : domains) {
                String cypher = String.format("match(n:`%s`) return count(n)", domainItem.getName());
                long nodeCount = Neo4jUtil.getGraphValue(cypher);
                if (nodeCount < 10) {
                    System.out.println("正在清理：" + domainItem.getName());
                    kgService.deleteDomain(domainItem.getId());
                    kgGraphService.deleteKGDomain(domainItem.getName());
                    // 删除索引
                    Neo4jUtil.deleteIndex(domainItem.getName());
                    //删除索引 drop index index_114254bd
                    List<HashMap<String, Object>> collect = graphIndex.stream().filter(n -> {
                        String[] labelsOrTypes = n.get("labelsOrTypes").toString().split(",");
                        List<String> labels = Arrays.asList(labelsOrTypes);
                        if (labels.contains(domainItem.getName())) {
                            return true;
                        }
                        return false;
                    }).collect(Collectors.toList());
                    if (collect.size() > 0) {
                        HashMap<String, Object> indexMp = collect.get(0);
                        String indexName = indexMp.get("name").toString().replace("\"", "");
                        String dropIndexCy = String.format("drop index %s", indexName);
                        Neo4jUtil.runCypherSql(dropIndexCy);
                    }

                    i++;
                }
            }
            System.out.println("清理完成,共清理" + i + "个标签");
        }
    }

    @Test
    void contextLoads2() {
        List<HashMap<String, Object>> domains = Neo4jUtil.getGraphLabels();
        int i = 0;
        if (domains != null && domains.size() > 0) {
            List<HashMap<String, Object>> graphIndex = Neo4jUtil.getGraphIndex();
            for (HashMap<String, Object> domainItem : domains) {
                String label = domainItem.get("label").toString();
                String cypher = String.format("match(n:`%s`) return count(n)", label);
                long nodeCount = Neo4jUtil.getGraphValue(cypher);
                if (nodeCount < 10) {
                    // 删除索引
                    Neo4jUtil.deleteIndex(label);
                    i++;
                }
            }
            System.out.println("清理完成,共清理" + i + "个标签");
        }
    }

    @Test
    void eventTest() {
//        String result = "{\"变更\":{\"时间\":\"未提及\",\"牧场名\":\"迈宁意信牧场\",\"变更人姓名\":\"未提及\",\"法定代表人发生变更是否对融资业务产生重大影响\":\"客户公司迟迟未走经营者变更手续\",\"新的变更人是否提供保证\":\"车宜媛已提供连带担保，且与父亲共同经营牧场\"}}";
        String result = "{\"变更\":{\"时间\":\"未提及\",\"牧场名\":\"迈宁意信牧场\",\"变更人姓名\":\"未提及\",\"法定代表人发生变更是否对融资业务产生重大影响\":\"客户公司迟迟未走经营者变更手续\",\"新的变更人是否提供保证\":\"车宜媛已提供连带担保，且与父亲共同经营牧场\"}}";
//        JSONObject jsonObject = JSONUtil.parseObj(result);
//        String eventType = jsonObject.getStr("变更");
//        JSONObject eventArgument = JSONUtil.parseObj(eventType);
//        System.out.println(eventArgument.getStr("时间"));
        TraverseJSONUtil.traverseJsonObject(JSONUtil.parseObj(result));
    }

    @Test
    void jsonTest() {
        String input = "{\"时间\":\"未提及\",\"去世人姓名\":\"车兰轮\",\"去世人身份\":\"法定代表人\",\"去世原因\":\"病逝\"}";

        String parsedJson = TraverseJSONUtil.parse(input);
        System.out.println(parsedJson);
    }

    @Test
    void TestJSON() {
        String eventExtractResult = "{\"去世\":{\"时间\":\"未提及\",\"去世人姓名\":\"车兰轮\",\"去世人身份\":\"法定代表人\",\"去世原因\":\"病逝\"}}";
        JSONObject jsonObj = JSONUtil.parseObj(eventExtractResult);

        String eventType;
        JSONObject eventArgument = null;
        for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
            eventType = entry.getKey();
            if (entry.getValue() instanceof JSONObject) {
                eventArgument = (JSONObject) entry.getValue();
            }

            System.out.println(eventType + "::" + eventArgument);
//            NodeItem nodeItem = new NodeItem();
//            nodeItem.setName(key);
//            HashMap<String, Object> node = kgGraphService.createNode(domain, nodeItem);
//                System.out.println(node);//{r=30, color=#ff4500, uuid=154}

        }
        if (eventArgument != null) {
            for (Map.Entry<String, Object> entry : eventArgument.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println("$$$" + key + ": " + value);
            }
        }
//        if (value instanceof JSONObject) {
//                for (java.util.Map.Entry<String, Object> entry1 : jsonObj.entrySet()) {
//                    String key1 = entry1.getKey();
//                    Object value1 = entry1.getValue();
//                    System.out.println("$$$" + key1 + ": " + value1);
////                        HashMap<String, Object> childNode = kgGraphService.batchCreateChildNode(domain, node.get("uuid").toString()
////                                , 0, Arrays.copyOf(new String[]{key1}, 1), value1.toString());
////                        rss.putAll(childNode);
//                }
//                else {
//                    System.out.println(key + ": " + value);
//                }
    }


}
