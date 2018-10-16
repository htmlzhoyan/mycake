/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LikeService
 * Author:   邦哥的电脑
 * Date:     2018-10-15 16:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.service;

import com.zy.shirozy.domain.Like;
import com.zy.shirozy.vo.R;

import java.util.List;

public interface LikeService {


    boolean add(Like like);
    R update(Like like);
    R delete(int id);
    List<Like> queryAll();
    Like selectById(int id);

}


