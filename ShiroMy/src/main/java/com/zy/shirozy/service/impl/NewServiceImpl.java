/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: NewServiceImpl
 * Author:   邦哥的电脑
 * Date:     2018-10-14 15:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zy.shirozy.service.impl;

import com.zy.shirozy.common.ResultUtil;
import com.zy.shirozy.domain.New;
import com.zy.shirozy.mapper.NewMapper;
import com.zy.shirozy.service.NewService;
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
public class NewServiceImpl implements NewService {

    @Autowired
    private NewMapper newMapper;


    @Override
    public R deleteById(Integer id) {
        return ResultUtil.setRes(newMapper.deleteByid(id));

    }

    @Override
    public boolean insert(New record) {
        return newMapper.insert(record) > 0;
    }

    @Override
    public R updateById(New record) {
        return ResultUtil.setRes(newMapper.updateByid(record));
    }

    @Override
    public List<New> queryAll() {
        return newMapper.queryAll();
    }
}


