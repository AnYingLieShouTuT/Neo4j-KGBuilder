package com.warmer.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgRules;
import com.warmer.web.service.KgRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rules")
public class RuleController {
    @Autowired
    private KgRulesService kgRulesService;

    //分页查询规则库
    @GetMapping("/rulesPage/{pageCode}/{pageSize}")
    public Page<KgRules> getPageRules(@PathVariable(value = "pageCode") int pageCode,
                                      @PathVariable(value = "pageSize") int pageSize) {
        Page<KgRules> pageInfo = kgRulesService.getPageRules(pageCode, pageSize);
        return pageInfo;
    }
}
