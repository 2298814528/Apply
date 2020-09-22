package com.group9.apply.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group9.apply.entity.Company;

import com.group9.apply.entity.Job;
import com.group9.apply.entity.User;
import com.group9.apply.util.MapToPageVo;
import com.group9.apply.util.Result;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
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
    public Result addDate(String name, String address, String description){
        User user = (User) session.getAttribute("user");
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        company.setDescription(description);
        companyService.save(company);
        return new Result(200,"add success",null);
    }

    /**
     * 跳转发布简历
     */


    @GetMapping("/jobList")
    public String jobList(){
        return "company/job-list";
    }

    @GetMapping("/jobAdd")
    public String jobAdd(){
        return "company/job-add";
    }

    @GetMapping("/companyMain")
    public String companyMain(){
        return "company/indexCompany";
    }


    @GetMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    @GetMapping("/companyInfo")
    public String companyInfo(){
        return "company/CompanyInfo";
    }

    /**
     * 显示某个公司信息
     * @param id  公司ID
     * @return
     */
    @GetMapping("/getSelectCompany")
    public String getSelectCompany(String id){
        Company company = companyService.getOne(new QueryWrapper<Company>().eq("id", Integer.valueOf(id)));
        request.setAttribute("oneCompany",company);
        IPage<Job> publisher = jobService.page(new Page<>(0, 3), new QueryWrapper<Job>().eq("publisher", company.getId()));
        request.setAttribute("hotJob",publisher.getRecords());
        return "company/getCompanyInfo";
    }

}
