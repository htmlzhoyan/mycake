package com.zy.shirozy.contorller;

import com.zy.shirozy.domain.Publish;
import com.zy.shirozy.domain.User;
import com.zy.shirozy.service.PublishService;
import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class PublishController {
    @Autowired
    public PublishService publishService;

    @RequestMapping("/publish.do")
    @ResponseBody
    public R selectByUid(HttpSession session) {
        User user = (User) session.getAttribute("user");

        List<Publish> list = publishService.findByUid(user.getId());
        R r = new R();
        r.setCode(1);
        r.setData(list);
        return r;
    }
}
