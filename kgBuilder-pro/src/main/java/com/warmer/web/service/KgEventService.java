package com.warmer.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgEvent;

import java.util.List;

public interface KgEventService {
    Page<KgEvent> getPageEvent(int pageCode, int pageSize);

    List<KgEvent> getAllEvent();

    KgEvent getEventById(int id);
}
