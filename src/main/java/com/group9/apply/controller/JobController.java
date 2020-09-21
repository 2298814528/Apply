package com.group9.apply.controller;


import cn.hutool.core.util.StrUtil;
import com.group9.apply.util.MapToPageVo;
import com.group9.apply.util.Result;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.group9.apply.controller.BaseController;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
    
    
    @Autowired
    MapToPageVo mapToPageVo;
    /**
     * 根据搜索条件返回相应的工作（无参数时返回整个）
     *
     * @param map 筛选条件
     * @return
     */
    //（薪资范围、职位类型、工作地点、入职时间、公司名字、学历要求、工作经验）
    @ResponseBody
    @GetMapping({"/search", "/jobList"})
    public Result searchJob(@RequestParam Map map) {
        Result result = new Result();
        PageVo pageVo = mapToPageVo.get(map);
        List<JobVo> jobList = jobService.getJob(pageVo);
        result.setData(jobList);
        result.setCode(1);
        result.setMsg("成功");
        return result;
    }

}
