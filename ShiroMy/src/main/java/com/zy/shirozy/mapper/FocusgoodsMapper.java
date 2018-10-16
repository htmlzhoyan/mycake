package com.zy.shirozy.mapper;


/**
 * 用户商品
 * 增加，删除，展示
 */

import com.zy.shirozy.domain.Focusgoods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FocusgoodsMapper {

    @Delete("delete from t_focusgoods where id = #{id}")
    int deleteById(Integer id);

    @Insert("insert into t_focusgoods (goodid, user) values (#{goodid,jdbcType=INTEGER}, #{user,jdbcType=VARCHAR} )")
    int insert(Focusgoods focusgoods);

    //根据id查询商品
    @Select("select * from t_focusgoods where id = #{id}")
    Focusgoods selectById(Integer id);

    //展示所有
    @Select("select * from t_focusgoods")
    List<Focusgoods> queryAll();

    @Update("update t_focusgoods set goodid = #{goodid,jdbcType=INTEGER}, user = #{user,jdbcType=VARCHAR} where id = #{id,jdbcType=INTEGER}")
    int updateById(Focusgoods focusgoods);
}