/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LikeServiceImpl
 * Author:   邦哥的电脑
 * Date:     2018-10-15 16:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.service.impl;

import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.Like;
import com.zy.shirozy.mapper.LikeMapper;
import com.zy.shirozy.service.LikeService;
import com.zy.shirozy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public boolean add(Like like) {
        return likeMapper.insert(like)>0;
    }

    @Override
    public R update(Like like) {
        return ResultUtil.setRes(likeMapper.updateById(like));
    }

    @Override
    public R delete(int id) {
        return ResultUtil.setRes(likeMapper.deleteById(id));
    }

    @Override
    public List<Like> queryAll() {
        return likeMapper.queryAll();
    }

    @Override
    public Like selectById(int id) {
        return likeMapper.selectById(id);
    }
}


