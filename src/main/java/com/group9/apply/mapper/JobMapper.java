package com.group9.apply.mapper;

import com.group9.apply.entity.Job;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 工作表 Mapper 接口
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
public interface JobMapper extends BaseMapper<Job> {

    List<JobVo> getSearchJob(@Param("job") PageVo pageVo);

    List<Job> listAll();
}
