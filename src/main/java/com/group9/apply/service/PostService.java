package com.group9.apply.service;

import com.group9.apply.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group9.apply.entity.PostList;
import com.group9.apply.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author smr
 * @since 2020-09-20
 */
public interface PostService extends IService<PostList> {

    /*
    * 通过Id查找用户
    * */
    List<PostList> findById(Integer id);

    /*
    * 单条数据删除
    *
    * */
    Result deleteone(Integer id);

    /**
     * 多条数据删除
     */
    Result delete(String[] ids);
}
