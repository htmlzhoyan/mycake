package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.New;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface NewMapper {

    @Delete("delete from t_new where id = #{id,jdbcType=INTEGER}")
    int deleteByid(Integer id);

    @Insert("insert into t_new (id, aid) values (#{id,jdbcType=INTEGER}, #{aid,jdbcType=INTEGER})")
    int insert(New record);

    @Select("select * from t_new")
    @ResultType(New.class)
    List<New> queryAll();

    @Update("update t_new set aid = #{aid,jdbcType=INTEGER} where id = #{id,jdbcType=INTEGER}")
    int updateByid(New record);
}