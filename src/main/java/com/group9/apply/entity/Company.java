package com.group9.apply.entity;

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
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司名字
     */
    private String name;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 公司描述
     */
    private String descption;

    /**
     * 公司id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

}
