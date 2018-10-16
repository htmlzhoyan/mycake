package com.zy.shirozy.contorller;

import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.service.impl.UserServiceImpl;
import com.zy.shirozy.vo.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("userregister.do")
    public R save(User user){
        return userService.save(user);
    }


    @PostMapping("/userlogin.do")
    public R login(String name, String password, HttpServletRequest request){
        User user = userService.login(name, password);
        if(user!=null){
            Subject subject=SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            request.getSession(true).setAttribute("name", name);
            subject.getSession().setAttribute("user",user);
            subject.login(token);
            return ResultUtil.setOK("登录成功");
        }else {
            return ResultUtil.setERROR("用户名或密码错误");
        }

    }
    //显示用户名
    @RequestMapping(value = "showname.do")
    public R showUserName(HttpSession session){

        R r = userService.checkName((String) session.getAttribute("name"));

        return r;
    }

    //修改个人资料
    @RequestMapping(value ="userupdate.do")
    @ResponseBody
    public String updateUserById(User user){
        if(userService.updateUserById(user)){
            return "redirect:/memenber.html";
        }else {
            return "redirect:/EditData.html";
        }
    }
}
