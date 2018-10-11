/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: AuthorityDao
 * Author:   邦哥的电脑
 * Date:     2018-10-10 22:19
 * Description: aa
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.plig.dao;

import com.plig.entity.Authority;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈aa〉
 *
 * @author 邦哥的电脑
 * @create 2018-10-10
 * @since 1.0.0
 */
public interface AuthorityDao {

    //登录权限
    @Select("SELECT DISTINCT r.info FROM t_user u INNER JOIN t_userrole ur ON u.id=ur.uid INNER JOIN t_role r ON ur.rid=r.id WHERE u.no=#{no}")
    Set<String> findRoleByNo(String no);

    @Select("SELECT DISTINCT a.title FROM t_user u INNER JOIN t_userrole ur ON ur.uid=u.id INNER JOIN t_roleauthority ar ON ar.rid=ur.rid INNER JOIN t_authority a on a.id=ar.aid INNER JOIN t_role r ON r.parentId=a.parentId  WHERE u.no=#{no}")
    Set<String> findPermitByNo(String no);

    @Select("SELECT a.* FROM t_user u INNER JOIN t_userrole ur ON ur.uid=u.id INNER JOIN t_roleauthority ar ON ar.rid=ur.rid INNER JOIN t_authority a on a.id=ar.aid INNER JOIN t_role r ON r.parentId=a.parentId  WHERE u.no=#{no}")
    Set<Authority> findByNo(String no);
}


