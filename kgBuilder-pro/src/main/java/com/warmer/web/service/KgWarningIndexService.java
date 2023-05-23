package com.warmer.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgWarningIndex;

import java.util.List;

public interface KgWarningIndexService {
    //分页
    Page<KgWarningIndex> getPageWarningIndex(int pageCode, int pageSize);

    List<KgWarningIndex> getAllWarningIndex();

    KgWarningIndex getWarningIndex(int id);
}
