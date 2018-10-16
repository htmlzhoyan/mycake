package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.Roleauthority;

public interface RoleauthorityMapper {
    int deleteByPrimaryKey(Roleauthority key);

    int insert(Roleauthority record);

    int insertSelective(Roleauthority record);
}