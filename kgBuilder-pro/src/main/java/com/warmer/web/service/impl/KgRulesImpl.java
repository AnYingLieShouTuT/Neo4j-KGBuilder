package com.warmer.web.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgRules;
import com.warmer.web.mapper.KgRulesMapper;
import com.warmer.web.service.KgRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KgRulesImpl implements KgRulesService {
    @Autowired
    private KgRulesMapper kgRulesMapper;

    @Override
    public Page<KgRules> getPageRules(int pageCode, int pageSize) {
        //1.创建Page对象，传入两个参数：当前页和每页显示记录数
        Page<KgRules> page = new Page<>(pageCode, pageSize);
        //2.将分页查询到的所有数据封装到Page对象中
        kgRulesMapper.selectPage(page, null);
        return page;
    }

    @Override
    public List<KgRules> getAllRules() {
        return kgRulesMapper.selectList(null);
    }
}
