package com.group9.apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group9.apply.entity.User;
import com.group9.apply.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(userService);
        User one = userService.getOne(new QueryWrapper<User>().eq("username", "张三"));
        System.out.println(one);
    }

}
