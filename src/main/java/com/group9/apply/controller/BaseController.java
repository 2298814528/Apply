package com.group9.apply.controller;

import com.group9.apply.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    CompanyService companyService;

    @Autowired
    JobService jobService;

    @Autowired
    PostService postService;

    @Autowired
    SeekerService seekerService;

    @Autowired
    UserService userService;
}
