package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.RoleauthorityKey;

public interface RoleauthorityMapper {
    int deleteByPrimaryKey(RoleauthorityKey key);

    int insert(RoleauthorityKey record);

    int insertSelective(RoleauthorityKey record);
}