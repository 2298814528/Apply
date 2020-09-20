package com.group9.apply.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.group9.apply.entity.Job;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.group9.apply.controller.BaseController;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Controller
@RequestMapping("/job")
public class JobController extends BaseController {
    //薪资范围、职位类型、工作地点、入职时间、公司名字、学历要求、工作经验

    /**
     * 获取岗位列表、分类
     * @param job
     * @return
     */
    @GetMapping("/jobList")
    public List<Job> getJobList(Job job){
        BigDecimal defaultSalary = new BigDecimal("0");
//        jobService.list(new QueryWrapper<Job>()
//            .eq(null != job.getSalary(),"salary",job.getSalary())
//            .eq());
        return null;
    }
}
