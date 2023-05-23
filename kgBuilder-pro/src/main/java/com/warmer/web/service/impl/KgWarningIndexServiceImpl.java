package com.warmer.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgWarningIndex;
import com.warmer.web.mapper.KgWarningIndexMapper;
import com.warmer.web.service.KgWarningIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KgWarningIndexServiceImpl implements KgWarningIndexService {

    @Autowired
    private KgWarningIndexMapper kgWarningIndexMapper;

    @Override
    public Page<KgWarningIndex> getPageWarningIndex(int pageCode, int pageSize) {
        //1.创建Page对象，传入两个参数：当前页和每页显示记录数
        Page<KgWarningIndex> page = new Page<>(pageCode, pageSize);
        //2.将分页查询到的所有数据封装到Page对象中
        kgWarningIndexMapper.selectPage(page, null);
        return page;
    }

    @Override
    public List<KgWarningIndex> getAllWarningIndex() {
        return kgWarningIndexMapper.selectList(null);
    }

    @Override
    public KgWarningIndex getWarningIndex(int id) {
        return kgWarningIndexMapper.selectOne(new QueryWrapper<KgWarningIndex>().eq("id", id));
    }
}
