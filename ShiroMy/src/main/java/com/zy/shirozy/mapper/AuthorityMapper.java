package com.zy.shirozy.mapper;


import com.zy.shirozy.domain.Authority;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer id);

    @Select("SELECT DISTINCT a1.* from t_authority a1\n" +
            "    INNER JOIN t_roleauthority roa\n" +
            "    on a1.id = roa.aid\n" +
            "    INNER JOIN t_role r\n" +
            "    on roa.rid = r.id ORDER BY a1.parentId asc,a1.id asc")
    @ResultType(Authority.class)
    List<Authority> selectByParentId();

    //找到菜单
    @Select("SELECT  a.* from t_authority a LEFT JOIN t_roleauthority roa on a.id = roa.aid  LEFT JOIN t_userrole ur on ur.rid = roa.rid LEFT JOIN t_user u on ur.uid=u.id where a. type=1 and u.id=1 ORDER BY a.parentId asc,a.id")
    @ResultType(Authority.class)
    List<Authority> selectByMenuUid(int uid);

    @Select("SELECT * from t_authority where parentId = #{parentId}")
    @ResultType(Authority.class)
    List<Authority> selectByParent(Integer id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}