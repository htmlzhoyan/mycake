package com.zy.shirozy.mapper;

import com.zy.shirozy.domain.Publish;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserPublishMapper {

    @Select("select * from t_publish where uid=#{uid}")
    @ResultType(Publish.class)
    List<Publish> selectByUid(int uid);
}