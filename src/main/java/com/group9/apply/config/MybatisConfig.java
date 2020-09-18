package com.group9.apply.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.group9.apply.mapper")
public class MybatisConfig {
    /**
     * mybatis-plus分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //        设置请求的页面大于最大页的操作，true返回首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(true);
        //        paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }
}
