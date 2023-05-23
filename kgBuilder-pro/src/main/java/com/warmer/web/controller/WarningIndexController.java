package com.warmer.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.base.util.R;
import com.warmer.web.entity.KgWarningIndex;
import com.warmer.web.service.KgWarningIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WarningIndexController extends BaseController {


    @Autowired
    private KgWarningIndexService kgWarningIndexService;

    @ResponseBody
    @RequestMapping(value = "/warningIndexPage")
    public R<Page<KgWarningIndex>> getPageWarningIndex(int pageCode, int pageSize) {
        try {
            Page<KgWarningIndex> pageInfo = kgWarningIndexService.getPageWarningIndex(pageCode, pageSize);
            return R.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/warningIndexAll")
    public R<List<KgWarningIndex>> getAllWarningIndex() {
        try {
            List<KgWarningIndex> rules = kgWarningIndexService.getAllWarningIndex();
            return R.success(rules);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }


}
