package com.zy.shirozy.service.impl;

import com.zy.shirozy.common.PassUtil;
import com.zy.shirozy.domain.Authority;
import com.zy.shirozy.domain.Focususer;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.mapper.AuthorityMapper;

import com.zy.shirozy.mapper.FocususerMapper;
import com.zy.shirozy.mapper.UserMapper;
import com.zy.shirozy.service.UserService;
import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.vo.MenuVo;

import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2018/10/12 11:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    public FocususerMapper focususerMapper;
    //注册
    @Override
    public R save(User user) {

        user.setPassword(PassUtil.md5(user.getPassword()));
        user.setNo(user.getName());
        System.out.println(user);
        return ResultUtil.setRes(userMapper.insert(user));
    }


    //查询展示用户名
    @Override
    public R checkName(String name) {
        User user = userMapper.selectByName(name);
        R r = new R(1,user.getName(), null);
        return r;
    }


    //登录
    @Override
    public User login(String name, String password) {
        User user = userMapper.selectByName(name);
        if(user!=null){
            System.out.println(user.getPassword());
            if(Objects.equals(user.getPassword(), PassUtil.md5(password))){
                return  user;
            }
        }
        return  null;
    }

    @Override
    public R updateRole(int[] rids, int uid) {
        return null;
    }

    @Override
    public List<MenuVo> queryMenu(int uid) {

        List<Authority> total = authorityMapper.selectByMenuUid(uid);
        List<MenuVo> menuVos = new ArrayList<>();
        for (Authority a: total) {
            if(a.getParentid() == 0){
                MenuVo menuVo = new MenuVo();
                menuVo.setParent(a);
                menuVo.setChildrens(new ArrayList<>());
                menuVos.add(menuVo);
            }else{
                int index = indexParent(menuVos,a);
                if(index > 0){
                    menuVos.get(index).getChildrens();
                }
            }
        }
        return menuVos;
    }

    private int indexParent(List<MenuVo> menuVos,Authority authority){
        for(int i=0;i<menuVos.size();i++){
            if(menuVos.get(i).getParent().getId().intValue()==authority.getParentid().intValue()){
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean updateUserById(User user) {
        return userMapper.updateByNo(user)>0;
    }

    //粉丝数量
    @Override
    public int selectCountBeByUid(int uid) {
        int count = 0;
        if (uid != 0) {
            count = focususerMapper.selectCountBeByUid(uid);
        }
        return count;
    }

    //关注人数
    @Override
    public int selectCountToByUid(int uid) {
        int count = 0;
        if (uid != 0) {
            count = focususerMapper.selectCountToByUid(uid);
        }
        return count;
    }

    @Override
    public List<User> selectFansByUid1(int uid) {
        List<User> list = null;
        if (uid != 0) {
            list = focususerMapper.selectFansByUid1(uid);
        }
        return list;
    }

    @Override
    public List<User> selectFansByUid0(int uid) {
        List<User> list = null;
        if (uid != 0) {
            list = focususerMapper.selectFansByUid0(uid);
        }
        return list;
    }

    @Override
    public Focususer selectByToAndBe(int uid_to, int uid_be) {
        Focususer focususer = null;
        if (uid_to != 0 && uid_be != 0) {
            focususer = focususerMapper.selectByToAndBe(uid_to, uid_be);
        }
        return focususer;
    }

    @Override
    public int deleteByToAndBe(int uid_to, int uid_be) {
        return focususerMapper.deleteByToAndBe(uid_to, uid_be);
    }

    @Override
    public int insertByToAndBe(int uid_to, int uid_be) {
        return focususerMapper.insertByToAndBe(uid_to, uid_be);
    }

    @Override
    public int updateByToAndBe1(int uid_to, int uid_be) {
        return focususerMapper.updateByToAndBe1(uid_to, uid_be);
    }

    @Override
    public int updateByToAndBe0(int uid_to, int uid_be) {
        return focususerMapper.updateByToAndBe0(uid_to, uid_be);
    }


}
