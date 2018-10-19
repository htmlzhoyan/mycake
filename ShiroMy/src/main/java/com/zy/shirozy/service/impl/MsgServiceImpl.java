package com.zy.shirozy.service.impl;

import com.zy.shirozy.mapper.MsgMapper;
import com.zy.shirozy.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {
    @Autowired
    private MsgMapper msgMapper;

    @Override
    public int countOfMsg(int uid) {
        int count = 0;
        if (uid != 0) {
            count = msgMapper.selectCountOfMsgByUid(uid);
        }
        return count;
    }
}
