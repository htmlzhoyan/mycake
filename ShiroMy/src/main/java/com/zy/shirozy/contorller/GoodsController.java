/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GoodsController
 * Author:   邦哥的电脑
 * Date:     2018-10-14 16:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.contorller;


import com.zy.shirozy.domain.GoodDetaill;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.service.GoodDetaillService;
import com.zy.shirozy.service.impl.GoodDetaillServiceImpl;

import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 邦哥的电脑
 * @create 2018-10-14
 * @since 1.0.0
 */
@Controller
public class GoodsController {

    @Autowired
    private GoodDetaillServiceImpl goodDetaillService;



    @RequestMapping(value = "/goodsadd.do",method = {RequestMethod.POST})
    @ResponseBody
    public R add(GoodDetaill goodDetaill, HttpSession session) {

        R r = new R();
        goodDetaill.setStart(0);
        goodDetaill.setLike(0);
        User user = (User) session.getAttribute("uname");
        goodDetaill.setUser(user.getNo());
        System.out.println(goodDetaill.getName());
        boolean intT = goodDetaillService.insert(goodDetaill);
        if(intT){
           return new R(200,"添加成功",null);
        }else {
           return new R(400,"添加失败",null);
        }
    }
    @RequestMapping(value = "/goodsDetail",method = {RequestMethod.GET})
    @ResponseBody
    public R selectByGoodsid(Integer id){
        List<GoodDetaill> list= null;
        list = goodDetaillService.selectByGoodsid(id);
        R r = new R();
        r.setCode(200);
        r.setMsg("获取成功");
        r.setData(list);

        return r;

    }

    @RequestMapping(value = "/photoupload",method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> upload(MultipartFile file){
        System.out.println(file.getOriginalFilename());
        String fName =(new Date().getTime()) + file.getOriginalFilename();
        Map<String, Object> map = new HashMap<>();
        String path = "C:\\elip\\ShiroMy\\mycake\\ShiroMy\\target\\classes\\static\\upload";
        File f1 = new File(path);
        if(!f1.exists()){
            f1.mkdirs();
        }
        File f = new File(path,fName);
        try {
            //上传文件
            file.transferTo(f);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        map.put("code", 0);// 针对layui的表格，0表示成功
        map.put("msg", "");
        map.put("data", fName);
        return map;

    }
}


