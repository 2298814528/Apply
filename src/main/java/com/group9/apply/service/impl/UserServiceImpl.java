package com.group9.apply.service.impl;

import com.group9.apply.entity.User;
import com.group9.apply.mapper.UserMapper;
import com.group9.apply.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录表 服务实现类
 * </p>
 *
 * @author zjj
 * @since 2020-09-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
