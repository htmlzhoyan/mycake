package com.zy.shirozy.service;

import com.zy.shirozy.domain.Publish;

import java.util.List;

public interface PublishService {
    List<Publish> findByUid(int uid);
}
