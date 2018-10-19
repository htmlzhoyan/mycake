package com.zy.shirozy.mapper;

import com.zy.shirozy.domain.Publish;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PublishMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Publish record);

    int insertSelective(Publish record);

    Publish selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Publish record);

    int updateByPrimaryKey(Publish record);

    @Select("select * from t_publish where uid=#{uid}")
    @ResultType(Publish.class)
    List<Publish> selectByUid(int uid);
}