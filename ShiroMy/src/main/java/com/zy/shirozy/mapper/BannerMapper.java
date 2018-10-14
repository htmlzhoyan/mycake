package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.Banner;
import org.apache.ibatis.annotations.Select;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);
    @Select("select * from t_banner")
    Banner selectByPrimary();

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}