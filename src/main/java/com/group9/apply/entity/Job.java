package com.group9.apply.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 发布公司ID
     */
    private Long publisher;

    /**
     * 岗位名
     */
    private String name;

    /**
     * ☆该字段使该表不满足2NF，部分依赖于id与publisher
     */
    private String location;

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
     * 薪资待遇：原文档中为varchar，改为decimal更合理
     */
    private BigDecimal salary;

    /**
     * 发布时间
     */
    private LocalDateTime pubTime;


}
