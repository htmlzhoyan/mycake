package com.zy.shirozy.service.impl;

import com.zy.shirozy.domain.Authority;
import com.zy.shirozy.mapper.AuthorityMapper;
import com.zy.shirozy.service.AuthorityServie;
import com.zy.shirozy.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityServie {

    @Autowired
    private AuthorityMapper authorityMapper;


    @Override
    public List<Authority> selectByParent(Integer id) {
        return authorityMapper.selectByParent(id);
    }


}
