package com.warmer.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgWarningIndex;

import java.util.List;

public interface KgWarningIndexService {
    Page<KgWarningIndex> getPageWarningIndex(int pageCode, int pageSize);

    List<KgWarningIndex> getAllWarningIndex();

    KgWarningIndex getWarningIndexById(int id);
}
