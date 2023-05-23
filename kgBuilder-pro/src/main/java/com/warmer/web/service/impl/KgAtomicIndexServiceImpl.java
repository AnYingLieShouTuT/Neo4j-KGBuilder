package com.warmer.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgAtomicIndex;
import com.warmer.web.mapper.KgAtomicIndexMapper;
import com.warmer.web.service.KgAtomicIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KgAtomicIndexServiceImpl implements KgAtomicIndexService {

    @Autowired
    private KgAtomicIndexMapper kgAtomicIndexMapper;

    @Override
    public Page<KgAtomicIndex> getPageAtomicIndex(int pageCode, int pageSize) {
        //1.创建Page对象，传入两个参数：当前页和每页显示记录数
        Page<KgAtomicIndex> page = new Page<>(pageCode, pageSize);
        //2.将分页查询到的所有数据封装到Page对象中
        kgAtomicIndexMapper.selectPage(page, null);
        return page;
    }

    @Override
    public List<KgAtomicIndex> getAllAtomicIndex() {
        return kgAtomicIndexMapper.selectList(null);
    }

    @Override
    public KgAtomicIndex getAtomicIndex(int id) {
        return kgAtomicIndexMapper.selectOne(new QueryWrapper<KgAtomicIndex>().eq("id", id));
    }
}
