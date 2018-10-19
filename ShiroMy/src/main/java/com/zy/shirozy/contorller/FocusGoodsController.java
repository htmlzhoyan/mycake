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
import com.zy.shirozy.domain.GoodDetaill;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.service.FocusGoodsService;
import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FocusGoodsController {

    @Autowired
    private FocusGoodsService focusGoodsService;

    @RequestMapping("/focusgoodslist.do")
    @ResponseBody
    public R selectByUid(HttpSession session) {
        User user = (User)session.getAttribute("user");
        List<GoodDetaill> list = focusGoodsService.selectByUid(user.getId());
        R r = new R();
        r.setCode(1);
        r.setData(list);

        return r;
    }

}


