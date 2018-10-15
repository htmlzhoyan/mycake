package com.zy.shirozy.service.impl;

import com.zy.shirozy.common.PassUtil;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.mapper.UserMapper;
import com.zy.shirozy.service.UserService;
import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.vo.MenuVo;

import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public R save(User user) {

        user.setPassword(PassUtil.md5(user.getPassword()));
        user.setNo(user.getName());
        System.out.println(user);
        return ResultUtil.setRes(userMapper.insert(user));
    }

    @Override
    public R checkName(String name) {
        return null;
    }

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

        return null;
    }



    @Override
    public boolean updateUserById(User user) {
        return userMapper.updateByNo(user)>0;
    }
}
