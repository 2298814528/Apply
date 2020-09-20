package com.group9.apply.service.impl;

import com.group9.apply.entity.Job;
import com.group9.apply.mapper.JobMapper;
import com.group9.apply.service.JobService;
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
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

}
