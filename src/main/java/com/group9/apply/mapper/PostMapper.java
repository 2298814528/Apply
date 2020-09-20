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
 * @author smr
 * @since 2020-09-20
 */
public interface PostMapper extends BaseMapper<PostList> {

    /*
    * 按照求职者Id查询
    * */
    List<PostList> findByUserid(@Param("userId") Integer userId);

    /**
     *
     * 单条数据删除
     */
    void deleteById(@Param("id")Integer id);

    /**
     *
     * 多条数据删除
     */
    void deleteByIds(@Param("ids")String ids[]);
}
