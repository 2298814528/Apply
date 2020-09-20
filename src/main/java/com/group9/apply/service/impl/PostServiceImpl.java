package com.group9.apply.service.impl;

import com.group9.apply.entity.Post;
import com.group9.apply.entity.PostList;
import com.group9.apply.mapper.PostMapper;
import com.group9.apply.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group9.apply.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, PostList> implements PostService {

    @Resource
    PostMapper postMapper;


    @Override
    public List<PostList> findById(Integer id) {
        return postMapper.findByUserid(id);
    }

    /*
    * 删除单条数据
    * */
    @Override
    public Result deleteone(Integer id) {
        postMapper.deleteById(id);
        return new Result(200,"删除成功!");
    }

    /*
    * 多条数据删除
    * */
    @Override
    public Result delete(String[] ids) {
        postMapper.deleteByIds(ids);
        return new Result(200,"删除成功！");
    }
}
