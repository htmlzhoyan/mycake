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
    public List<MenuVo> queryAll() {
        List<Authority> total = authorityMapper.selectByParentId();
        List<MenuVo> menuVos = new ArrayList<>();
        for(Authority p:total){
            if(p.getParentid()==0){
                MenuVo menuVo = new MenuVo();
                menuVo.setParent(p);
                menuVo.setChildrens(new ArrayList<>());
                menuVos.add(menuVo);
            }else{
               
            }
        }
            return  menuVos;
    }


}
