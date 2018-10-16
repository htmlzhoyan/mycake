/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FocusGoodsServiceImpl
 * Author:   邦哥的电脑
 * Date:     2018-10-15 18:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.service.impl;

import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.Focusgoods;
import com.zy.shirozy.mapper.FocusgoodsMapper;
import com.zy.shirozy.service.FocusGoodsService;
import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 邦哥的电脑
 * @create 2018-10-15
 * @since 1.0.0
 */
@Service
public class FocusGoodsServiceImpl implements FocusGoodsService {

    @Autowired
    private FocusgoodsMapper focusgoodsMapper;

    @Override
    public boolean add(Focusgoods focusgoods) {
        return focusgoodsMapper.insert(focusgoods)>0;
    }

    @Override
    public R update(Focusgoods focusgoods) {
        return ResultUtil.setRes(focusgoodsMapper.updateById(focusgoods));
    }

    @Override
    public R delete(int id) {
        return ResultUtil.setRes(focusgoodsMapper.deleteById(id));
    }

    @Override
    public List<Focusgoods> queryAll() {
        return focusgoodsMapper.queryAll();
    }

    @Override
    public Focusgoods selectById(int id) {
        return focusgoodsMapper.selectById(id);
    }
}


