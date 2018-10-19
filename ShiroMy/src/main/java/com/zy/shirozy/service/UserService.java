package com.zy.shirozy.service;



import com.zy.shirozy.domain.Focususer;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.vo.MenuVo;
import com.zy.shirozy.vo.R;

import java.util.List;


public interface UserService {

    //注册
    R save(User user);
    //校验是否存在
    R checkName(String name);
    //登录---账号是否存在临时无效
    User login(String name, String password);

//    void saveLog(LoginLog loginLog);
    //更新角色
    R updateRole(int[] rids, int uid);


    List<MenuVo> queryMenu(int uid);

    //修改个人资料
    boolean updateUserById(User user);

    //粉丝数量
    int selectCountBeByUid(int uid);

    //关注人数
    int selectCountToByUid(int uid);

    List<User> selectFansByUid1(int uid);

    List<User> selectFansByUid0(int uid);

    Focususer selectByToAndBe(int uid_to, int uid_be);

    int deleteByToAndBe(int uid_to, int uid_be);

    int insertByToAndBe(int uid_to, int uid_be);

    int updateByToAndBe1(int uid_to, int uid_be);

    int updateByToAndBe0(int uid_to, int uid_be);





}
