package com.group9.apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group9.apply.entity.User;
import com.group9.apply.service.UserService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver","D:\\\\work\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://search.51job.com/list/000000,000000,0000,00,9,99,java,2,1.html?lang=c&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&ord_field=0&dibiaoid=0&line=&welfare=";
        driver.get(url);
        Document document = Jsoup.parse(driver.getPageSource());
        Elements ets = document.getElementsByClass("jname at");
        for (Element e:ets ) {
            System.out.println(e.text());
        }
    }
}
