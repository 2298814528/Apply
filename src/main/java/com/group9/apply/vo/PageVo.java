package com.group9.apply.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class PageVo {
    /**
     * 储存数据库查询的条件
     */
    private JobVo jobVo;
    /**
     * 当前页数
     */
    private Integer currentPage;
    /**
     * 排序
     */
    private String order;
    /**
     * 每页的页数
     */
//    private Integer limit = 10;

}
