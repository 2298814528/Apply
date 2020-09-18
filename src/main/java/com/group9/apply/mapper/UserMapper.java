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

}
