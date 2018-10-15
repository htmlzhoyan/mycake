package com.zy.shirozy.service.impl;

import com.zy.shirozy.domain.Authority;
import com.zy.shirozy.mapper.AuthorityMapper;
import com.zy.shirozy.service.AuthorityServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityServie {

    @Autowired
    private AuthorityMapper authorityMapper;
    @Override
    public List<Authority> queryAll() {
        List<Authority> list = authorityMapper.selectByParentId();
        return  list;
    }
}
