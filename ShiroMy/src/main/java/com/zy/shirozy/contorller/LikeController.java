/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LikeController
 * Author:   邦哥的电脑
 * Date:     2018-10-15 17:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.contorller;


import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.Like;
import com.zy.shirozy.service.LikeService;
import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LikeController {

    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/likeadd.do", method = {RequestMethod.POST})
    public String add(Like like){
        if(likeService.add(like)){
            return "redirect:/likelist.html";
        }else{
            return "redirect:/likeadd.html";
        }
    }

    @RequestMapping(value = "likedel.do",method = {RequestMethod.POST})
    @ResponseBody
    public R delect(int id){

        return likeService.delete(id);
    }

    @RequestMapping(value = "likeupdate.do",method = {RequestMethod.POST})
    @ResponseBody
    public R update(Like like){

        return likeService.update(like);
    }

    @RequestMapping("/likeall.do")
    public List<Like> queryAll(){
        return likeService.queryAll();
    }
}


