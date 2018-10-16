package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.GoodDetaill;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodDetaillMapper {

    @Delete("delete from t_gooddetaill where id = #{id,jdbcType=INTEGER}")
    int deleteByid(Integer id);

    @Insert("insert into t_gooddetaill (goodid, start, like, user, name,img) values (#{goodid}, #{start},  #{like}, #{user}, #{name}, #{img})")
    int insert(GoodDetaill goodDetaill);

    @Select("select * from t_gooddetaill")
    List<GoodDetaill> queryAll();
    @Update("update t_gooddetaill set goodid = #{goodid,jdbcType=VARCHAR}, start = #{start,jdbcType=INTEGER}, like = #{like,jdbcType=INTEGER}, user = #{user,jdbcType=VARCHAR}, name = #{name,jdbcType=VARCHAR} ,where id = #{id,jdbcType=INTEGER}")
    int updateById(GoodDetaill record);

    @Select("select * from t_gooddetail where goodid = #{goodid}")
    List<GoodDetaill> selectByGoodsid(Integer goodid);

}