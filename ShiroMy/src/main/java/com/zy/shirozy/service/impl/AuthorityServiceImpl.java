package com.zy.shirozy.service.impl;

import com.zy.shirozy.domain.Authority;
import com.zy.shirozy.mapper.AuthorityMapper;
import com.zy.shirozy.service.AuthorityService;
import com.zy.shirozy.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService {

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
                int index=indexPareng(menuVos,p);
                if(index>-1){
                    menuVos.get(index).getChildrens().add(p);
                }
            }
        }
        System.out.println(menuVos);
        return  menuVos;
    }

    @Override
    public List<Authority> selectByParent(Integer id) {
        return authorityMapper.selectByParent(id);
    }

    @Override
    public List<Authority> selectByBanner() {
        return authorityMapper.selectByBanner();
    }

    @Override
    public List<Authority> selectByNew() {
        return authorityMapper.selectByNew();
    }

    @Override
    public List<Authority> selectByParentById() {
        return authorityMapper.selectByParentById();
    }

    private int indexPareng(List<MenuVo> menuVos,Authority authority){
        for (int i = 0; i < menuVos.size() ; i++) {
            if(menuVos.get(i).getParent().getId().intValue()==authority.getParentid().intValue()){
                return i;
            }
        }
        return -1;
    }
}
