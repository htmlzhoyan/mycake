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
import com.zy.shirozy.service.GoodDetaillService;
import com.zy.shirozy.service.impl.GoodDetaillServiceImpl;
import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String add(GoodDetaill goodDetaill){
        if(goodDetaillService.insert(goodDetaill)){
            return "redirect:/goodslist.html";
        }else {
            return "redirect:/goodsadd.html";
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
}


