package com.warmer.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.base.util.R;
import com.warmer.web.entity.KgRules;
import com.warmer.web.service.KgRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private KgRulesService kgRulesService;

    //分页查询规则库
//    @GetMapping("/rulesPage/{pageCode}/{pageSize}")
//    @ResponseBody
//    @RequestMapping(value = "/rulesPage")
//    public R<Page<KgRules>> getPageRules(int pageCode,int pageSize) {
//        try {
//            Page<KgRules> pageInfo = kgRulesService.getPageRules(pageCode, pageSize);
//            System.out.println(pageInfo.getTotal());
//            System.out.println("rule!!!!!!!!!!!!");
//            return R.success(pageInfo);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return R.error(e.getMessage());
//        }
//    }

    @GetMapping("/rulesPage/{pageCode}/{pageSize}")
    public R<Page<KgRules>> getPageRules(@PathVariable(value = "pageCode") int pageCode,
                                         @PathVariable(value = "pageSize") int pageSize) {
        Page<KgRules> pageInfo = kgRulesService.getPageRules(pageCode, pageSize);
        System.out.println(pageInfo.getTotal());
        System.out.println("rule!!!!!!!!!!!!");
        return R.success(pageInfo);
    }
}
