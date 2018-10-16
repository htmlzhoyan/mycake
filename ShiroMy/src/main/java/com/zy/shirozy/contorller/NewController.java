/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: NewController
 * Author:   邦哥的电脑
 * Date:     2018-10-14 15:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.contorller;


import com.zy.shirozy.common.FileUtils;
import com.zy.shirozy.domain.New;
import com.zy.shirozy.service.NewService;
import com.zy.shirozy.vo.R;
import com.zy.shirozy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class NewController {

    @Autowired
    private NewService newService;

    @RequestMapping(value = "/newadd.do",method = {RequestMethod.POST})
    public String add(New news){
        if(newService.insert(news)){
            return "redirect:/newlist.html";
        }else{
            return "redirect:/newadd.html";
        }
    }



    @RequestMapping(value = "/newdel.do",method = {RequestMethod.POST})
    @ResponseBody
    public R delete(int id){
        return newService.deleteById(id);
    }

    @RequestMapping(value = "/newupdate.do",method = {RequestMethod.POST})
    public String update(New news){
        if(newService.updateById(news).getCode() ==200){
            return "redirect:/newlist.html";
        }else {
            return "redirect:/newupdate.html";
        }
    }

    //展示所有
    @RequestMapping(value = "listall.do",method = {RequestMethod.POST})
    public List<New> queryAll(){
        return newService.queryAll();
    }


    //上传照片
    @RequestMapping(value="photoupload.do",method= {RequestMethod.POST})
    @ResponseBody
    public ResultVo upload(@RequestParam("file") MultipartFile mFile, HttpServletRequest request) {
        File dir = FileUtils.createDir(request.getServletContext().getRealPath("/"), "photos");
        File file=new File(dir, FileUtils.createFileName(mFile.getOriginalFilename()));
        try {
            mFile.transferTo(file);
            return ResultVo.setOK(dir.getName()+ File.separator+file.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.setERROR("错了");
        }
    }

}


