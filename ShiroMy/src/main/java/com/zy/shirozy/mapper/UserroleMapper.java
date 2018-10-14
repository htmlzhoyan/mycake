package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.UserroleKey;

public interface UserroleMapper {


    int insert(UserroleKey record);

    int insertSelective(UserroleKey record);
}