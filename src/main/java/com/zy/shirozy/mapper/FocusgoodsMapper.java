package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.Focusgoods;

public interface FocusgoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Focusgoods record);

    int insertSelective(Focusgoods record);

    Focusgoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Focusgoods record);

    int updateByPrimaryKey(Focusgoods record);
}