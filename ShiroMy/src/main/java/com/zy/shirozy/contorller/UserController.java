package com.zy.shirozy.contorller;

import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.Focususer;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.service.MsgService;
import com.zy.shirozy.service.impl.UserServiceImpl;
import com.zy.shirozy.vo.MenuVo;
import com.zy.shirozy.vo.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private MsgService msgService;

    @PostMapping("userregister.do")
    public R save(User user){
        return userService.save(user);
    }


    @PostMapping("/userlogin.do")
    public R login(String name, String password, HttpServletRequest request,HttpSession session){
        User user = userService.login(name, password);
        if(user!=null){
            Subject subject=SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            session.setAttribute("uname",user);
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
        R r = new R();
        r.setCode(200);
        r.setMsg("获取成功");
        r.setData(session.getAttribute("uname"));
        return r;
        //return userService.checkName((String) session.getAttribute("name"));
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

    //粉丝数量、关注人数和消息数量
    @RequestMapping("count.do")
    @ResponseBody
    public R selectCountBeByUid(HttpSession session) {
        User user = (User)session.getAttribute("user");
        //关注人数
        int count1 = userService.selectCountBeByUid(user.getId());
        //粉丝数量
        int count2 = userService.selectCountToByUid(user.getId());
        //消息数量
        int count3 = msgService.countOfMsg(user.getId());

        String count4 = user.getPhoto();

        Map<String, Object> map = new HashMap<>();
        map.put("uname", user.getName());
        map.put("countbe", count1);
        map.put("countto", count2);
        map.put("countmsg", count3);
        map.put("countmsg", count3);
        map.put("photo", count4);
        R r = new R();
        r.setCode(1);
        r.setData(map);

        return r;
    }

    @RequestMapping("/fanslist.do")
    @ResponseBody
    public R selectFans(HttpSession session) {
        R r = new R();
        Map<String, Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");

        List<User> list1 = userService.selectFansByUid1(user.getId());
        List<User> list0 = userService.selectFansByUid0(user.getId());
        map.put("list1", list1);
        map.put("list0", list0);

        r.setCode(1);
        r.setData(map);
        return r;
    }

    @PostMapping("/changeflag.do")
    @ResponseBody
    public R changeFlag(HttpSession session, int id) {
        R r = new R();
        User user = (User)session.getAttribute("user");
        Focususer focususer = userService.selectByToAndBe(id, user.getId());
        if (focususer.getFlag() == 1) {
            userService.deleteByToAndBe(user.getId(), id);
            userService.updateByToAndBe1(id, user.getId());
        } else {
            userService.insertByToAndBe(user.getId(), id);
            userService.updateByToAndBe0(id, user.getId());
        }
        r.setCode(1);

        return r;
    }
}
