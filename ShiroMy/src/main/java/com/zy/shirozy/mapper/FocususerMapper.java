package com.zy.shirozy.mapper;

import com.zy.shirozy.domain.Focususer;
import com.zy.shirozy.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FocususerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Focususer record);

    int insertSelective(Focususer record);

    Focususer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Focususer record);


    //粉丝数量
    @Select("select count(1) from t_focususer where uid_be=#{uid}")
    int selectCountToByUid(int uid);

    //关注的人数
    @Select("select count(1) from t_focususer where uid_to=#{uid}")
    int selectCountBeByUid(int uid);

    @Select("select u.* from t_user u inner join t_focususer fu on u.id=fu.uid_to where fu.uid_be=#{uid} and fu.flag=1")
    List<User> selectFansByUid1(int uid);

    @Select("select u.* from t_user u inner join t_focususer fu on u.id=fu.uid_to where fu.uid_be=#{uid} and fu.flag=0")
    List<User> selectFansByUid0(int uid);

    @Select("select * from t_focususer where uid_to=#{uidto} and uid_be=#{uidbe}")
    Focususer selectByToAndBe(@Param("uidto") int uidto, @Param("uidbe") int uidbe);

    @Delete("delete from t_focususer where uid_to=#{uidto} and uid_be=#{uidbe}")
    int deleteByToAndBe(@Param("uidto") int uidto, @Param("uidbe") int uidbe);

    @Insert("insert into t_focususer(uid_to, uid_be, createdate, flag) value(#{uidto}, #{uidbe}, now(), 1)")
    int insertByToAndBe(@Param("uidto") int uidto, @Param("uidbe") int uidbe);

    @Update("update t_focususer set flag=0 where uid_to=#{uidto} and uid_be=#{uidbe}")
    int updateByToAndBe1(@Param("uidto") int uidto, @Param("uidbe") int uidbe);

    @Update("update t_focususer set flag=1 where uid_to=#{uidto} and uid_be=#{uidbe}")
    int updateByToAndBe0(@Param("uidto") int uidto, @Param("uidbe") int uidbe);
}