package com.group9.apply.mapper;

import com.group9.apply.entity.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zjj
 * @since 2020-09-20
 */
@Repository
public interface CompanyMapper extends BaseMapper<Company> {

    public int addCompany(long id,String name,String address,String description);
}
