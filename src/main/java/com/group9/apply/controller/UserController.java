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
            if (user.getRole().equals("1")) {
                return new Result(1, "seeker login", null);
            } else if (user.getRole().equals(2)) {
                return new Result(2, "company login", null);
            } else {
                return new Result(0, "manager login", null);
            }
        } else {
            return new Result(400, "username or password error", null);
        }
    }

    /**
     * 跳转到求职者主界面
     */
    @GetMapping("/doLogin")
    public String toLoginSeeker() {
        return"indexCompany";
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
    public String register(String username, String password, String role1, HttpServletResponse response) throws Exception {
        User user = new User();
        int role = 0;
        if (role1.equals("求职者")) {
            role = 1;
        } else if (role1.equals("企业")) {
            role = 2;
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        if (userService.save(user)) {
            return "";//注册成功返回到登陆界面
        } else {
            return JSON.toJSONString(new Result(400, "register error", null));
        }
    }
}
