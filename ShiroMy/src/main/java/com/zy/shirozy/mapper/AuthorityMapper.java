package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.Authority;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer id);


    List<Authority> selectByParentId();

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}