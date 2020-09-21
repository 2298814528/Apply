package com.group9.apply.service.impl;

import com.group9.apply.entity.Job;
import com.group9.apply.mapper.JobMapper;
import com.group9.apply.service.JobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group9.apply.util.PageResult;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 工作表 服务实现类
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

    @Resource
    JobMapper jobMapper;

    @Override
    public List<JobVo> getJob(PageVo pageVo) {
        return jobMapper.getSearchJob(pageVo);
    }

    @Override
    public JobVo getOneJob(Integer id) {
        return jobMapper.getOne(id);
    }


}
