package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.UserMsg;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<UserMsg> allUsersForMap();
    public Map<String,Integer> dataOfRegisterPeople(List<Integer> days);
}
