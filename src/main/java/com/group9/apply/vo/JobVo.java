package com.group9.apply.vo;

import lombok.Data;

import java.util.Date;

@Data
public class JobVo {


    private Long id;
    /**
     * 发布公司ID
     */
    private Long publisher;

    /**
     * 岗位名
     */
    private String name;

    /**
     * 岗位类型
     */
    private String type;

    /**
     * ☆该字段使该表不满足2NF，部分依赖于id与publisher
     */
    private String location;

    /**
     * 学历
     */
    private String education;

    /**
     * 最小薪资
     */
    private Integer minSalary;

    /**
     * 最大薪资
     */
    private Integer maxSalary;

    /**
     * 工作经验
     */
    private Integer experience;

    /**
     * 入职时间
     */
    private Date entryTime;

    /**
     * 岗位联系人电话
     */
    private String phone;

    /**
     * 岗位联系人邮箱
     */
    private String email;

    /**
     * 岗位需求
     */
    private String trade;

    /**
     * ☆该字段使该表不满足2NF，部分依赖于id与publisher
     */
    private String tip;

    /**
     * 发布时间
     */
    private Date pubTime;
    /**
     * 公司名字
     */
    private String company;

}
