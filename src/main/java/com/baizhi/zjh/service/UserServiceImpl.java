package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.User;
import com.baizhi.zjh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void login(User user) {
        userMapper.selectOne(user);
    }
}
