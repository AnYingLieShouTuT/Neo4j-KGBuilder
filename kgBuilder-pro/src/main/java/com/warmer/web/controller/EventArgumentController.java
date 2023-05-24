package com.warmer.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.base.util.R;
import com.warmer.web.entity.KgEvent;
import com.warmer.web.entity.KgEventArgument;
import com.warmer.web.service.KgEventArgumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EventArgumentController extends BaseController {

    @Autowired
    private KgEventArgumentService kgEventArgumentService;

    @ResponseBody
    @RequestMapping(value = "/eventArgumentPage")
    public R<Page<KgEvent>> eventArgumentPage(int pageCode, int pageSize) {
        try {
            Page<KgEventArgument> pageInfo = kgEventArgumentService.getPageEventArgument(pageCode, pageSize);
            return R.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/eventArgumentAll")
    public R<List<KgEventArgument>> getAllEventArgument() {
        try {
            List<KgEventArgument> events = kgEventArgumentService.getAllEventArgument();
            return R.success(events);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

}
