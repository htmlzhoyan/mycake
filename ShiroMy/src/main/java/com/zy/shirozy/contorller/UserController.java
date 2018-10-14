package com.zy.shirozy.contorller;

import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.serviceimpl.UserServiceImpl;
import com.zy.shirozy.vo.R;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/userlogin.do")
    public R login(String name, String password, HttpServletRequest request){
        User user = userService.login(name, password);
        if(user!=null){
            Subject subject=SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            subject.getSession().setAttribute("user",user);
            subject.login(token);
            return ResultUtil.setOK("登录成功");
        }else {
            return ResultUtil.setERROR("用户名或密码错误");
        }

    }
}
