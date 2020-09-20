package com.group9.apply.config;

import com.group9.apply.interceptor.LoginInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LoginInter loginInter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(loginInter);
        List<String> list = new ArrayList<>();
        list.add("/user/login");
        list.add("/user/doLogin");
        list.add("/user/register");
        list.add("/user/userExit");
        list.add("/static/**");
        interceptor.addPathPatterns("/**").excludePathPatterns(list);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/**");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}