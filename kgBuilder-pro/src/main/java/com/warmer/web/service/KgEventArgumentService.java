package com.warmer.web.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.web.entity.KgEventArgument;

import java.util.List;

public interface KgEventArgumentService {
    Page<KgEventArgument> getPageEventArgument(int pageCode, int pageSize);

    List<KgEventArgument> getAllEventArgument();

    KgEventArgument getEventArgumentById(int id);
}
