package com.group9.apply.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.group9.apply.entity.Seeker;
import com.group9.apply.entity.User;
import com.group9.apply.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Controller
@RequestMapping("/seeker")
public class SeekerController extends BaseController {


    @GetMapping("/toJianli")
    public String toJianli() {
        User user = (User) session.getAttribute("user");
        long id = user.getId();
        Seeker seeker = seekerService.getOne(new QueryWrapper<Seeker>().eq("id", id));
        request.setAttribute("seeker", seeker);
        return "seeker/jianli";
    }

    /**
     * 修改简历的逻辑处理
     *
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestParam Map map) throws ParseException {
        User user = (User) session.getAttribute("user");
        Long id = user.getId();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Seeker seeker = new Seeker();
        String sex = (String) map.get("sex");
        Date enrollmentTime = format.parse((String) map.get("enrollmentTime"));
        Date graduationTime = format.parse((String) map.get("graduationTime"));
        seeker.setName((String) map.get("name"));
        seeker.setSex(Integer.valueOf(sex));
        seeker.setSchool((String) map.get("school"));
        seeker.setEduBackground((String) map.get("eduBackground"));
        seeker.setMajor((String) map.get("major"));
        seeker.setEnrollmentTime(enrollmentTime);
        seeker.setGraduationTime(graduationTime);
        if (seekerService.update(seeker, new UpdateWrapper<Seeker>().eq("id", id))) {
            return new Result(200);
        } else {
            return new Result(400);
        }
    }

    @GetMapping("/toSeekerInfor")
    public String toSeekerInfor() {
        User user = (User) session.getAttribute("user");
        long id = user.getId();
        Seeker seeker = seekerService.getOne(new QueryWrapper<Seeker>().eq("id", id));
        request.setAttribute("seeker2", seeker);
        return "seeker/SeekerInfor";
    }

    /*
     *跳转到修改简历界面
     */
    @GetMapping("/updateSeeker")
    public String updateSeeker() {
        return "seeker/updateJinali";
    }

}