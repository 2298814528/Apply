package com.group9.apply.controller;


import com.group9.apply.entity.Job;
import com.group9.apply.util.Result;
import com.group9.apply.vo.JobVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.group9.apply.controller.BaseController;

import java.util.List;

/**
 * <p>
 * 工作表 前端控制器
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Controller
@RequestMapping("/job")
public class JobController extends BaseController {
//（薪资范围、职位类型、工作地点、入职时间、公司名字、学历要求、工作经验）
    @PostMapping({"/search","/jobList"})
    public Result searchJob(Job job){
        Result result = new Result();
        List<JobVo> JobList = jobService.getJob(job);
        return result;
    }

}
