/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FocusGoodsController
 * Author:   邦哥的电脑
 * Date:     2018-10-15 19:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.contorller;

import com.zy.shirozy.domain.Focusgoods;
import com.zy.shirozy.service.FocusGoodsService;
import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FocusGoodsController {

    @Autowired
    private FocusGoodsService focusGoodsService;

    @RequestMapping(value = "focusgoodsadd.do",method = {RequestMethod.POST})
    public String add(Focusgoods focusgoods){
        if(focusGoodsService.add(focusgoods)){
            return "redirect:/focuslist.html";
        }else{
            return "redirect:/focusgoodsadd.html";
        }

    }

}


