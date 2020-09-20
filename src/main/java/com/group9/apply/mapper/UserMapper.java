package com.group9.apply.mapper;

import com.group9.apply.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户登录表 Mapper 接口
 * </p>
 *
 * @author zjj
 * @since 2020-09-18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 求职者登陆
     */
    public int loginSeeker(User user);

    /**
     * 企业登陆
     */
    public int loginCompany(User user);

    /**
     * 超级管理员登陆
     */
    public int loginManager(User user);


}
