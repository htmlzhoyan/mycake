package com.zy.shirozy.contorller;

import com.zy.shirozy.domain.Authority;
import com.zy.shirozy.service.AuthorityServie;
import com.zy.shirozy.service.impl.AuthorityServiceImpl;
import com.zy.shirozy.vo.MenuVo;
import com.zy.shirozy.vo.R;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorityController {
    @Autowired
    private AuthorityServiceImpl authorityServie;
    @GetMapping("authority.do")
    public List<MenuVo> menus(){

        return authorityServie.queryAll();
    }
    @GetMapping("authorityById.do")
    public List<Authority> selectByParent(Integer id){
        return authorityServie.selectByParent(id);
    }

}
