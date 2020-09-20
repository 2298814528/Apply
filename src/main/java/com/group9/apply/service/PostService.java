package com.group9.apply.service;

import com.group9.apply.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group9.apply.entity.PostList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
public interface PostService extends IService<PostList> {

    /*
    * 通过Id查找用户
    * */
    List<PostList> findById(Integer id);
}
