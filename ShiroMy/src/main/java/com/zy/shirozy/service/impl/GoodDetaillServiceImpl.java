/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GoodDetaillServiceImpl
 * Author:   邦哥的电脑
 * Date:     2018-10-14 16:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.service.impl;

import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.GoodDetaill;
import com.zy.shirozy.mapper.GoodDetaillMapper;
import com.zy.shirozy.service.GoodDetaillService;
import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 邦哥的电脑
 * @create 2018-10-14
 * @since 1.0.0
 */
@Service
public class GoodDetaillServiceImpl implements GoodDetaillService {

    @Autowired
    private GoodDetaillMapper goodDetaillMapper;
    @Override
    public boolean insert(GoodDetaill goodDetaill) {
        return  goodDetaillMapper.insert(goodDetaill) > 0;
    }

    @Override
    public R deteleById(int id) {
        return ResultUtil.setRes( goodDetaillMapper.deleteByid(id));
    }

    @Override
    public R updateById(GoodDetaill goodDetaill) {
        return ResultUtil.setRes(goodDetaillMapper.updateById(goodDetaill));
    }

    @Override
    public List<GoodDetaill> queryAll() {
        return goodDetaillMapper.queryAll();
    }
}


