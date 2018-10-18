package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.GoodDetaill;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodDetaillMapper {

    @Delete("delete from t_gooddetail where id = #{id,jdbcType=INTEGER}")
    int deleteByid(Integer id);

    @Insert("insert into t_gooddetail (goodid, start, likes, user, name,img) values (#{goodid}, #{start},  #{like}, #{user}, #{name}, #{img})")
    @Options(useGeneratedKeys = true)
    int insert(GoodDetaill goodDetaill);

    @Select("select * from t_gooddetail")
    List<GoodDetaill> queryAll();
    @Update("update t_gooddetail set goodid = #{goodid,jdbcType=VARCHAR}, start = #{start,jdbcType=INTEGER}, like = #{like,jdbcType=INTEGER}, user = #{user,jdbcType=VARCHAR}, name = #{name,jdbcType=VARCHAR} ,where id = #{id,jdbcType=INTEGER}")
    int updateById(GoodDetaill record);

    @Select("select * from t_gooddetail where goodid = #{goodid}")
    List<GoodDetaill> selectByGoodsid(Integer goodid);

}