package com.group9.apply.controller;



import com.alibaba.fastjson.JSON;
import com.group9.apply.entity.Company;

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
        company.setDescption(description);
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

}
