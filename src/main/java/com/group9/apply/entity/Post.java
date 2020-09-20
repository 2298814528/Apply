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
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 投递者的USERID
     */
    private Long userId;

    /**
     * 所投递岗位的JOBID
     */
    private Long jobId;

    /**
     * 0:待审核
1：通过
2：未通过
     */
    private Integer postStatus;

    /**
     * 0：未删除
1：已删除
     */
    private Integer isDeleted;

    /**
     * 投递时间
     */
    private LocalDateTime postTime;

    /**
     * ☆更新时间：假如勾选“根据当前时间戳更新”，update操作后应该不会更新这个时间吧？
那么就应该用存储过程或者触发器实现：
1.存储过程的话就定义带参更新操作，更新操作完成后将update_time设置为当前时间；
2.触发器的话，在update后触发，将update_time直接更改为当前时间。
     */
    private LocalDateTime updateTime;


}
