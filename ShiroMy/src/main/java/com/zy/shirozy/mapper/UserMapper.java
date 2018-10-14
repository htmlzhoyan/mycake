package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("insert into t_user (no, password, name, sex, age, phone,headphoto, flag, note) values (" +
            "#{no,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR},#{name,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}," +
            " #{age,jdbcType=INTEGER}," +
            " #{phone,jdbcType=VARCHAR},#{headphoto,jdbcType=VARCHAR}," +
            " #{flag,jdbcType=INTEGER}, #{note,jdbcType=VARCHAR})")
    int insert(User record);

    @Select("select * from t_user where no=#{name} or name =#{name} and flag=1")
    @ResultType(User.class)
    User selectByName(String name);
}