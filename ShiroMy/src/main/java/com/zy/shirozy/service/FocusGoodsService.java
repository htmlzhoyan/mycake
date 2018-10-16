/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FocusGoodsService
 * Author:   邦哥的电脑
 * Date:     2018-10-15 17:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.service;


import com.zy.shirozy.domain.Focusgoods;
import com.zy.shirozy.vo.R;

import java.util.List;

public interface FocusGoodsService {

    boolean add(Focusgoods focusgoods);
    R update(Focusgoods focusgoods);
    R delete(int id);
    List<Focusgoods> queryAll();
    Focusgoods selectById(int id);

}


