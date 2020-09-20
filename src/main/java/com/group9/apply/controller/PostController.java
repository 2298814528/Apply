package com.group9.apply.controller;


import com.group9.apply.entity.PostList;
import com.group9.apply.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.group9.apply.controller.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/post")
public class PostController extends BaseController {
    @Autowired
    PostService postService;

    @GetMapping("/list")
    public String PostList(Model model,Integer id){
        List<PostList> list=postService.findById(id);
        model.addAttribute("list",list);
        return "Post/post-list";
    }
}
