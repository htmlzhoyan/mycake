package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.New;

public interface NewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(New record);

    int insertSelective(New record);

    New selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(New record);

    int updateByPrimaryKey(New record);
}