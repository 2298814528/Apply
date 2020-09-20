package com.group9.apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group9.apply.entity.User;
import com.group9.apply.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplyApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        BigDecimal bigDecimal1 = new BigDecimal("123");
        BigDecimal bigDecimal3 = new BigDecimal("123");
        BigDecimal bigDecimal2 = new BigDecimal("234");
        int i = bigDecimal1.compareTo(bigDecimal2);  //-1
        int j = bigDecimal2.compareTo(bigDecimal1);  //1
        int k = bigDecimal1.compareTo(bigDecimal3);  //0
    }

}
