package com.group9.apply.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.group9.apply.entity.Job;
import com.group9.apply.entity.PostList;
import com.group9.apply.service.PostService;
import com.group9.apply.util.MapToPageVo;
import com.group9.apply.util.Result;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.group9.apply.controller.BaseController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author smr
 * @since 2020-09-20
 */
@Controller
@RequestMapping("/post")
public class PostController extends BaseController {
    @Autowired
    MapToPageVo mapToPageVo;

    /*
     * 显示求职者所有简历投递信息
     * */
    @GetMapping("/list")
    public String PostList(Model model, Integer id) {
        List<PostList> list = postService.findById(id);
        model.addAttribute("list", list);
        return "post/post-list";
    }

    /**
     * 投递信息单条数据删除
     */
    @PostMapping("/deleteone")
    @ResponseBody
    public Result deleteone(@RequestParam(name = "id") Integer id) {
        return postService.deleteone(id);
    }


    /**
     * 多条删除
     *
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestParam(name = "ids[]") String[] ids) {
        return postService.delete(ids);
    }

    /**
     * 所有工作详情页
     * @param map
     * @return
     */
    @GetMapping("/allPost")
    public String allPost(@RequestParam(required = false) Map map) {
        String current = (String) map.get("current");
        IPage iPage = new Page(StrUtil.isNotBlank(current) ? Long.valueOf(current) : 0, 18);
        QueryWrapper<Job> queryWrapper = new QueryWrapper<Job>()
                .like(StrUtil.isNotBlank((String) map.get("location")), "location", (String) map.get("location"))
                .eq(StrUtil.isNotBlank((String) map.get("education")), "education", (String) map.get("education"))
                .eq(StrUtil.isNotBlank((String) map.get("experience")), "experience", (String) map.get("experience"))
                .gt(StrUtil.isNotBlank((String) map.get("minSalary")), "minSalary", (String) map.get("minSalary"))
                .lt(StrUtil.isNotBlank((String) map.get("maxSalary")), "maxSalary", (String) map.get("maxSalary"));
        IPage page = jobService.page(iPage, queryWrapper);
        request.setAttribute("page", page);
        return "post/allPost";
    }


}
