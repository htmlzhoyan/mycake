/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GoodDetaillService
 * Author:   邦哥的电脑
 * Date:     2018-10-14 16:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.service;

import com.zy.shirozy.domain.GoodDetaill;
import com.zy.shirozy.vo.R;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 邦哥的电脑
 * @create 2018-10-14
 * @since 1.0.0
 */
public interface GoodDetaillService {

    boolean insert(GoodDetaill goodDetaill);
    R deteleById(int id);
    R updateById(GoodDetaill goodDetaill);
    List<GoodDetaill> queryAll();
    List<GoodDetaill> selectByGoodsid(Integer goodId);

}


