package com.zy.shirozy.mapper;

import com.zy.shirozy.domain.Msg;
import org.apache.ibatis.annotations.Select;

public interface MsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);

    //消息数量
    @Select("select count(1) from t_msg where pid=#{uid}")
    int selectCountOfMsgByUid(int uid);
}