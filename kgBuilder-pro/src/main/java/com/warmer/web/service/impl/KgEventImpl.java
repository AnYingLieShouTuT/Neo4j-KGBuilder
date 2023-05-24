package com.warmer.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgEvent;
import com.warmer.web.mapper.KgEventMapper;
import com.warmer.web.service.KgEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KgEventImpl implements KgEventService {

    @Autowired
    private KgEventMapper kgEventMapper;

    @Override
    public Page<KgEvent> getPageEvent(int pageCode, int pageSize) {
        //1.创建Page对象，传入两个参数：当前页和每页显示记录数
        Page<KgEvent> page = new Page<>(pageCode, pageSize);
        //2.将分页查询到的所有数据封装到Page对象中
        kgEventMapper.selectPage(page, null);
        return page;
    }

    @Override
    public List<KgEvent> getAllEvent() {
        return kgEventMapper.selectList(null);
    }

    @Override
    public KgEvent getEventById(int id) {
        return kgEventMapper.selectOne(new QueryWrapper<KgEvent>().eq("id", id));
    }
}
