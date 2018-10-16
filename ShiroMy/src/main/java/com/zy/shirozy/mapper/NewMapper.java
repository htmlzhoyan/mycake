package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.New;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface NewMapper {

    @Delete("delete from t_new where id = #{id}")
    int deleteById(Integer id);

    @Insert("insert into t_new (newname, photo, shicai, step, headline, info) values (#{newname,jdbcType=VARCHAR}, #{photo,jdbcType=VARCHAR}, #{shicai,jdbcType=VARCHAR}, #{step,jdbcType=VARCHAR}, #{headline,jdbcType=VARCHAR}, #{info,jdbcType=VARCHAR})")
    int insert(New news);

    @Select("select * from t_new where id=#{id}")
    @ResultType(New.class)
    New selectById(Integer id);

    @Update("update t_new set newname = #{newname,jdbcType=VARCHAR}, photo = #{photo,jdbcType=VARCHAR}, shicai = #{shicai,jdbcType=VARCHAR}, step = #{step,jdbcType=VARCHAR}, headline = #{headline,jdbcType=VARCHAR}, info = #{info,jdbcType=VARCHAR} where id = #{id}")
    int updateById(New news);

    @Select("select * from t_new")
    @ResultType(New.class)
    List<New> queryAll();

}