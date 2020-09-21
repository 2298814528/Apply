package com.group9.apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group9.apply.entity.Job;
import com.group9.apply.entity.User;
import com.group9.apply.service.JobService;
import com.group9.apply.service.UserService;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyApplicationTests {

    @Autowired
    JobService jobService;

    @Test
    public void contextLoads() {
//        System.out.println(jobService);
//        JobVo jobVo = new JobVo();
//        jobVo.setMinSalary(100);
//        jobVo.setCompany("英特尔");
//        PageVo pageVo = new PageVo();
////        pageVo.setCurrentPage(1);
//        pageVo.setJobVo(jobVo);
        List<JobVo> job = jobService.getJob(new PageVo());
        System.out.println(job);
    }

}
