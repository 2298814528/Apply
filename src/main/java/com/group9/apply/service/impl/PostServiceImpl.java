package com.group9.apply.service.impl;

import com.group9.apply.entity.Post;
import com.group9.apply.mapper.PostMapper;
import com.group9.apply.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
