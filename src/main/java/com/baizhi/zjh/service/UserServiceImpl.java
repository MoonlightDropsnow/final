package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.UserMsg;
import com.baizhi.zjh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserMsg> allUsersForMap() {
        return userMapper.queryAllGroupByCity();
    }

    @Override
    public Map<String,Integer> dataOfRegisterPeople(List<Integer> days) {
        Map<String,Integer> userData = new HashMap();
        for(Integer day:days){
            Integer number = userMapper.queryUserNumberByTimeInterval(day*7);
            userData.put(day+"周",number);
        }
        return userData;
    }
}
