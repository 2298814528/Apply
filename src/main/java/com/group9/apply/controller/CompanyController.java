package com.group9.apply.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.group9.apply.entity.Company;

import com.group9.apply.entity.Job;
import com.group9.apply.entity.Seeker;
import com.group9.apply.entity.User;
import com.group9.apply.util.MapToPageVo;
import com.group9.apply.util.Result;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    MapToPageVo mapToPageVo;

    /**
     * 添加企业信息
     */
    @PostMapping("/addCompany")
    @ResponseBody
    public Result addDate(String name, String address, String description) {
        User user = (User) session.getAttribute("user");
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        company.setDescription(description);
        companyService.save(company);
        return new Result(200, "add success", null);
    }

    /**
     * 添加招聘信息
     *
     * @return
     */
    @PostMapping("/addJob")
    @ResponseBody
    public Result addJob(@RequestParam Map map) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user = (User) session.getAttribute("user");
        long id = user.getId();
        Job job = new Job();
        String minSalary = (String) map.get("min_salary");
        String maxSalary = (String) map.get("max_salary");
        String experience = (String) map.get("experience");
        Date entryTime = format.parse(String.valueOf(map.get("entry_time")));
        Date pubTime = format.parse(String.valueOf(map.get("put_time")));
        job.setName((String) map.get("name"));
        job.setType((String) map.get("type"));
        job.setLocation((String) map.get("location"));
        job.setEducation((String) map.get("education"));
        job.setPhone((String) map.get("phone"));
        job.setEmail((String) map.get("email"));
        job.setMinSalary(Integer.valueOf(minSalary));
        job.setMaxSalary(Integer.valueOf(maxSalary));
        job.setExperience(Integer.valueOf(experience));
        job.setEntryTime(entryTime);
        job.setTrade((String) map.get("trade"));
        job.setPubTime(pubTime);
        job.setPublisher(id);
        if (jobService.save(job)) {
            return new Result(200);
        } else {
            return new Result(400);
        }
    }


    @GetMapping("/jobList")
    public String jobList() {
        return "company/job-list";
    }

    @GetMapping("/jobAdd")
    public String jobAdd() {
        return "company/job-add";
    }

    @GetMapping("/companyMain")
    public String companyMain() {
        return "company/indexCompany";
    }


    @GetMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

    /**
     * 查询公司信息
     */
    @GetMapping("/selectCompanyInfo")
    public String selectCompanyInfo() {
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        Company company = companyService.getOne(new QueryWrapper<Company>().eq("id", id));
        request.setAttribute("company1", company);
        return "company/companyInfo";
    }

    /**
     * 首页显示公司信息
     *
     * @param id 公司ID
     * @return
     */
    @GetMapping("/getSelectCompany")
    public String getSelectCompany(String id) {
        Company company = companyService.getOne(new QueryWrapper<Company>().eq("id", Integer.valueOf(id)));
        request.setAttribute("company", company);
        return "company/getCompanyInfo";
    }

}
