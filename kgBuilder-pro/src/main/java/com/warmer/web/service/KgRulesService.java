package com.warmer.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgRules;

import java.util.List;

public interface KgRulesService {
    Page<KgRules> getPageRules(int pageCode, int pageSize);

    List<KgRules> getAllRules();

    KgRules getRuleById(int id);
}
