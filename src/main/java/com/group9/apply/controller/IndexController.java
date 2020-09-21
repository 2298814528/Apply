package com.group9.apply.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group9.apply.entity.Company;
import com.group9.apply.util.MapToPageVo;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController extends BaseController{
    @Autowired
    MapToPageVo mapToPageVo;

    @RequestMapping({"/index","/",""})
    public String index(){
        Map map = new HashMap<>();
        PageVo pageVo = mapToPageVo.get(map);
        List<JobVo> job = jobService.getJob(pageVo);
        request.setAttribute("jobList",job);
        IPage iPage = new Page(0,12);
        IPage name = companyService.page(iPage, new QueryWrapper<Company>()
                .orderByAsc("name"));
        session.setAttribute("company",name.getRecords());
        return "index";
    }

}
