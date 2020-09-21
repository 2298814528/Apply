package com.group9.apply.service;

import com.group9.apply.entity.Job;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group9.apply.vo.JobVo;

import java.util.List;

/**
 * <p>
 * 工作表 服务类
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
public interface JobService extends IService<Job> {

    List<JobVo> getJob(Job job);
}
