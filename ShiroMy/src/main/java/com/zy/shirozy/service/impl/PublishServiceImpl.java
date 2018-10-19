package com.zy.shirozy.service.impl;

import com.zy.shirozy.domain.Publish;

import com.zy.shirozy.mapper.NewMapper;
import com.zy.shirozy.mapper.UserPublishMapper;
import com.zy.shirozy.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishServiceImpl implements PublishService {
    @Autowired
    private UserPublishMapper userPublishMapper;

    @Override
    public List<Publish> findByUid(int uid) {
        List<Publish> list = null;
        if (uid != 0) {
            list = userPublishMapper.selectByUid(uid);
        }
        return list;
    }

    private class PublishMapper {
    }
}
