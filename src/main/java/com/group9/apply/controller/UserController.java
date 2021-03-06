package com.group9.apply.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group9.apply.util.Result;
import com.group9.apply.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 用户登录表 前端控制器
 * </p>
 *
 * @author zjj
 * @since 2020-09-18
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {


    /**
     * 跳转到登陆界面
     */
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    /**
     * 登陆逻辑
     */
    @PostMapping("/userExit")
    @ResponseBody
    public Result login(String username, String password, HttpServletResponse resp) throws Exception {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
            return new Result(200);
        }
        return new Result(400);

    }

    /**
     * 跳转到求职者主界面
     */
    @ResponseBody
    @GetMapping("/doLogin")
    public void toLoginSeeker() throws IOException {
        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        int i = requestURL.indexOf(requestURI);
        StringBuffer originalUrl = requestURL.delete(i, requestURL.length());
        String url = originalUrl.toString();
        response.sendRedirect(url);
    }

    /**
     * 跳转到企业主界面
     */
    @GetMapping("/toLoginCompany")
    public void toLoginCompany() {

    }

    /**
     * 跳转到超级管理员主界面
     */
    @GetMapping("/toLoginManager")
    public void toLoginManager() {

    }

    /**
     * 注册用户逻辑
     */
    @GetMapping("/register")
    public String toregister() {
        return "user/register";
    }

    @PostMapping("/doRegister")
    @ResponseBody
    public Result register(String username, String password, int role) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        if (userService.save(user)) {
            return new Result(200, "register success", null);
        } else {
            return new Result(400, "register error", null);
        }
    }

    /**
     * 用户退出实现
     *
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("user");
        return "index";
    }
}
