package com.warmer.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warmer.base.util.R;
import com.warmer.web.entity.KgAtomicIndex;
import com.warmer.web.entity.KgRules;
import com.warmer.web.service.KgAtomicIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AtomicIndexController extends BaseController {

    @Autowired
    private KgAtomicIndexService kgAtomicIndexService;

    @ResponseBody
    @RequestMapping(value = "/atomicIndexPage")
    public R<Page<KgRules>> atomicIndexPage(int pageCode, int pageSize) {
        try {
            Page<KgAtomicIndex> pageInfo = kgAtomicIndexService.getPageAtomicIndex(pageCode, pageSize);
            return R.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/atomicIndexAll")
    public R<List<KgAtomicIndex>> getAllAtomicIndex() {
        try {
            List<KgAtomicIndex> rules = kgAtomicIndexService.getAllAtomicIndex();
            return R.success(rules);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

}
