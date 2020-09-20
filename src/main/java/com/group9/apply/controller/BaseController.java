package com.group9.apply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;
}
