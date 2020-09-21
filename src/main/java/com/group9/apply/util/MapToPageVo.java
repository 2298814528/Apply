package com.group9.apply.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.group9.apply.vo.JobVo;
import com.group9.apply.vo.PageVo;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class MapToPageVo {

    public PageVo get(Map map) {
        PageVo pageVo = new PageVo();
        String currentPage = (String) map.get("currentPage");
        String order = (String) map.get("order");
        pageVo.setCurrentPage(null == currentPage ? 0 : Integer.valueOf(currentPage) * 12);
        pageVo.setOrder(null == order ? "pub_time" : order);
        JobVo jobVo = new JobVo();
//        Integer integer = Integer.valueOf(null);
        String company = (String) map.get("company");
        String minSalary = (String) map.get("minSalary");//1
        String maxSalary = (String) map.get("maxSalary");//1
        String type = (String) map.get("type");
        String location = (String) map.get("location");
        String entryTime = (String) map.get("entryTime");//Date
        String education = (String) map.get("education");
        String experience = (String) map.get("experience");
        jobVo.setCompany(StrUtil.isBlank(company)?null:company);
        jobVo.setEducation(StrUtil.isBlank(education)?null:education);
        jobVo.setLocation(StrUtil.isBlank(location)?null:location);
        jobVo.setType(StrUtil.isBlank(type)?null:type);
        jobVo.setExperience(null == experience ? null : Integer.valueOf(experience));
        jobVo.setMinSalary(null == minSalary ? null : Integer.valueOf(minSalary));
        jobVo.setMaxSalary(null == maxSalary ? null : Integer.valueOf(maxSalary));
        jobVo.setEntryTime(null == entryTime ? null : (Date) DateUtil.parseTime(entryTime));
        pageVo.setJobVo(jobVo);
        return pageVo;
    }
}
