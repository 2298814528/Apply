package com.group9.apply.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group9.apply.entity.PostList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
public interface PostMapper extends BaseMapper<PostList> {

    /*
    * 按照求职者Id查询
    * */
    List<PostList> findByUserid(@Param("userId") Integer userId);

}
