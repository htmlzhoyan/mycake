package com.zy.shirozy.contorller;

import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.service.impl.UserServiceImpl;
import com.zy.shirozy.vo.MenuVo;
import com.zy.shirozy.vo.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
            request.getSession.setAttribute("name",name);
            subject.getSession().setAttribute("user",user);
            subject.login(token);
            return ResultUtil.setOK("登录成功");
        }else {
            return ResultUtil.setERROR("用户名或密码错误");
        }

    }
    
    //显示用户名
    @RequestMapping("showname.do")
    public R showName(HttpSession session){

        return userService.checkName((String) session.getAttribute("name"));
    }
    
    //修改个人资料
    @RequestMapping(value ="userupdate.do")

    public String updateUserById(User user){
        if(userService.updateUserById(user)){
            return "redirect:/memenber.html";
        }else {
            return "redirect:/EditData.html";
        }
    }
    //查询菜单
    @GetMapping("usermenus.do")
    public List<MenuVo> menu(){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return userService.queryMenu(user.getId());
    }
}
