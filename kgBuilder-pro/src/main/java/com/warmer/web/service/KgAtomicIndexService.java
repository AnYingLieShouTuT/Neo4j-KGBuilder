package com.warmer.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgAtomicIndex;

import java.util.List;

public interface KgAtomicIndexService {
    //分页
    Page<KgAtomicIndex> getPageAtomicIndex(int pageCode, int pageSize);

    List<KgAtomicIndex> getAllAtomicIndex();

    KgAtomicIndex getAtomicIndex(int id);
}
