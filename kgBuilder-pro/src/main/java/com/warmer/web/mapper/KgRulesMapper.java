package com.warmer.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgRules;
import org.springframework.stereotype.Repository;

@Repository
public interface KgRulesMapper extends BaseMapper<KgRules> {
    //分页
    public Page<KgRules> getPageRules(int pageCode, int pageSize);
}
