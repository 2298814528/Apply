package com.group9.apply.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group9.apply.entity.Company;
import com.group9.apply.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.group9.apply.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {

    /**
     * 添加企业信息
     */
    @PostMapping("/addCompany")
    @ResponseBody
    public Result addDate(String name, String address, String description){
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        company.setDescption(description);
        companyService.save(company);
        return new Result(200,"add success",null);
    }

//    public Result upDate(){
//
//    }
}
