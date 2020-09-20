package com.group9.apply.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Seeker implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 求职者姓名
     */
    private String name;

    /**
     * 性别：0表示男，1表示女
     */
    private Integer sex;

    /**
     * 求职者毕业学校
     */
    private String school;

    /**
     * 求职者学历
     */
    private String eduBackground;

    /**
     * 求职者的专业
     */
    private String major;

    /**
     * 入学时间
     */
    private LocalDateTime enrollmentTime;

    /**
     * 毕业时间
     */
    private LocalDateTime graduationTime;

    /**
     * 公司名字
     */
    private String companyName;

    /**
     * 从事行业
     */
    private String profession;

    /**
     * 职位
     */
    private String position;

    /**
     * 所属部门
     */
    private String department;

    /**
     * 工作内容
     */
    private String content;

    /**
     * 工作开始时间
     */
    private LocalDateTime startTime;

    /**
     * 离职时间
     */
    private LocalDateTime endTime;

    /**
     * 个人主页
     */
    private String page;

    /**
     * 简历
     */
    private String resume;


}
