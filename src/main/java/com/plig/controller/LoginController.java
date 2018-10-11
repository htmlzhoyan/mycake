/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LoginController
 * Author:   邦哥的电脑
 * Date:     2018-10-10 22:52
 * Description: 登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.plig.controller;

import com.plig.utils.MD5Utils;
import com.plig.vo.JsonBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br>
 * 〈登录〉
 *
 * @author 邦哥的电脑
 * @create 2018-10-10
 * @since 1.0.0
 */
@Controller
public class LoginController {


    @RequestMapping("/fontcake/login")
    @ResponseBody
    public JsonBean login(String no, String password, HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(no, MD5Utils.md5(password));
        Subject subject = SecurityUtils.getSubject();
        JsonBean bean = new JsonBean();
        try {
            subject.login(token);

            bean.setCode(1);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            bean.setCode(0);
            bean.setMsg(e.getMessage());
        }
        return bean;
    }
}


