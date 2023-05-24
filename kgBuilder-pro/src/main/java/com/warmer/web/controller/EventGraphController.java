package com.warmer.web.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.warmer.base.util.R;
import com.warmer.web.model.NodeItem;
import com.warmer.web.service.KgEventArgumentService;
import com.warmer.web.service.KgEventService;
import com.warmer.web.service.KgGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class EventGraphController extends BaseController {

    @Autowired
    private KgEventService kgEventService;

    @Autowired
    private KgEventArgumentService kgEventArgumentService;

    @Autowired
    private KgGraphService kgGraphService;

    @ResponseBody
    @RequestMapping(value = "/addEventNode")
    public R<String> addEventNode(String domain, String eventExtractResult) {
//        System.out.println(domain + " " + eventExtractResult);
        List<HashMap<String, Object>> rss = new ArrayList<>();

        try {
            JSONObject jsonObj = JSONUtil.parseObj(eventExtractResult);

            String eventType;
            JSONObject eventArgument = null;
            NodeItem nodeItem = new NodeItem();
            HashMap<String, Object> node = new HashMap<>();
            for (Map.Entry<String, Object> entry : jsonObj.entrySet()) {
                eventType = entry.getKey();
                nodeItem.setName(eventType);
                node = kgGraphService.createNode(domain, nodeItem);
                if (entry.getValue() instanceof JSONObject) {
                    eventArgument = (JSONObject) entry.getValue();
                }
            }
            if (eventArgument != null) {
                for (Map.Entry<String, Object> entry : eventArgument.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    HashMap<String, Object> childNode = kgGraphService.batchCreateChildNode(domain, node.get("uuid").toString()
                            , 0, Arrays.copyOf(new String[]{value.toString()}, 1), key);
//                    System.out.println(childNode);
                    rss.add(childNode);
                }
            }
//            System.out.println("===========");
//            System.out.println(rss);
            return R.success(rss);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

}
