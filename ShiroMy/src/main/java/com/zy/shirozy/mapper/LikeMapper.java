package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LikeMapper {

    @Delete("delete from t_like where id = #{id}")
    int deleteById(Integer id);

    @Insert("insert into t_like (aid) values (#{aid})")
    int insert(Like like);
    @Select("select * from t_like where id=#{id}")
    Like selectById(Integer id);

    //查询所有
    @Select("select * from t_like")
    List<Like> queryAll();

    @Update("update t_like set aid = #{aid} where id = #{id}")
    int updateById(Like like);
}