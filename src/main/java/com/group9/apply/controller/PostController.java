package com.group9.apply.controller;


import com.group9.apply.entity.PostList;
import com.group9.apply.service.PostService;
import com.group9.apply.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.group9.apply.controller.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author smr
 * @since 2020-09-20
 */
@RestController
@RequestMapping("/post")
public class PostController extends BaseController {
    @Autowired
    PostService postService;

    /*
    * 显示求职者所有简历投递信息
    * */
    @GetMapping("/list")
    public String PostList(Model model,Integer id){
        List<PostList> list=postService.findById(id);
        model.addAttribute("list",list);
        return "Post/post-list";
    }

    /**
     * 投递信息单条数据删除
     */
    @PostMapping("/deleteone")
    @ResponseBody
    public Result deleteone(@RequestParam(name="id")Integer id){
        return postService.deleteone(id);}


    /**
     * 多条删除
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestParam(name="ids[]") String[] ids){
        return postService.delete(ids);
    }
}
