package com.warmer.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgEventArgument;
import com.warmer.web.mapper.KgEventArgumentMapper;
import com.warmer.web.service.KgEventArgumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KgEventArgumentImpl implements KgEventArgumentService {
    
    @Autowired
    private KgEventArgumentMapper kgEventArgumentMapper;

    @Override
    public Page<KgEventArgument> getPageEventArgument(int pageCode, int pageSize) {
        //1.创建Page对象，传入两个参数：当前页和每页显示记录数
        Page<KgEventArgument> page = new Page<>(pageCode, pageSize);
        //2.将分页查询到的所有数据封装到Page对象中
        kgEventArgumentMapper.selectPage(page, null);
        return page;
    }

    @Override
    public List<KgEventArgument> getAllEventArgument() {
        return kgEventArgumentMapper.selectList(null);
    }

    @Override
    public KgEventArgument getEventArgumentById(int id) {
        return kgEventArgumentMapper.selectOne(new QueryWrapper<KgEventArgument>().eq("id", id));
    }
}
