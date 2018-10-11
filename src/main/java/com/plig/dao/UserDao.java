/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserDao
 * Author:   邦哥的电脑
 * Date:     2018-10-10 22:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.plig.dao;

import com.plig.entity.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 邦哥的电脑
 * @create 2018-10-10
 * @since 1.0.0
 */
public interface UserDao {

    //注册
    int add(User user);

    //登录
    @Select("select * from t_user where no=#{no} and flag=1")
    @ResultType(User.class)
    User findUser(String no);
    User findUserByNo(String no);
}


