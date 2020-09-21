package com.group9.apply.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/seeker")
public class SeekerController extends BaseController {


    @GetMapping("/toJianli")
    public String toJianli(){
        return "seeker/jianli";
    }
}
