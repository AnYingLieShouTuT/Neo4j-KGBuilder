package com.warmer.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.warmer.web.entity.KgRules;

public interface KgRulesService{
    //分页
    public Page<KgRules> getPageRules(int pageCode, int pageSize);
}
