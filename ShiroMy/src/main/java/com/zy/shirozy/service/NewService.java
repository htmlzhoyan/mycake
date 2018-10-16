/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: NewService
 * Author:   邦哥的电脑
 * Date:     2018-10-14 15:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.service;

import com.zy.shirozy.domain.New;
import com.zy.shirozy.vo.R;

import java.util.List;


public interface NewService {

    R deleteById(Integer id);

    boolean insert(New record);

    R updateById(New record);



    List<New> queryAll();
}


