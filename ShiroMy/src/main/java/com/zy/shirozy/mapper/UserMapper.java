package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    //注册
    @Insert("insert into t_user (no, password, name, phone, flag) values (#{no},#{password},#{name},#{phone},#{flag})")
    int insert(User record);
    //登录
    @Select("select * from t_user where no=#{name} or name =#{name} and flag=1")
    @ResultType(User.class)
    User selectByName(String name);

    //修改个人资料
    @Update(" update t_user set no = #{no}, name =#{name}, sex =#{sex},age=#{age}, phone =#{phone}, note =#{note} where id =#{id}")
    int updateByNo(User user);


}