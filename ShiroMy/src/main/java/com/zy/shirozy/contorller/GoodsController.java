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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private GoodDetaillService goodDetaillService;

    @RequestMapping(value = "/goodsadd.do",method = {RequestMethod.POST})
    public String add(GoodDetaill goodDetaill){
        if(goodDetaillService.insert(goodDetaill)){
            return "redirect:/goodslist.html";
        }else {
            return "redirect:/goodsadd.html";
        }
    }
}


