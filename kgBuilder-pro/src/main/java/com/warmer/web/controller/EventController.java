package com.warmer.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.base.util.R;
import com.warmer.web.entity.KgEvent;
import com.warmer.web.service.KgEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EventController extends BaseController {

    @Autowired
    private KgEventService kgEventService;

    @ResponseBody
    @RequestMapping(value = "/eventPage")
    public R<Page<KgEvent>> eventPage(int pageCode, int pageSize) {
        try {
            Page<KgEvent> pageInfo = kgEventService.getPageEvent(pageCode, pageSize);
            return R.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/eventAll")
    public R<List<KgEvent>> getAllEvent() {
        try {
            List<KgEvent> events = kgEventService.getAllEvent();
            return R.success(events);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

}
