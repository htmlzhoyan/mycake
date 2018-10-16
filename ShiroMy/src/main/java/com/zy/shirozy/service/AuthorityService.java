package com.zy.shirozy.service;

import com.zy.shirozy.domain.Authority;
import com.zy.shirozy.domain.Like;
import com.zy.shirozy.vo.MenuVo;

import java.util.List;

public interface AuthorityService {
    List<MenuVo> queryAll();
    List<Authority> selectByParent(Integer id);
}
