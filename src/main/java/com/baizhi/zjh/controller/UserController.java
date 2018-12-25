package com.baizhi.zjh.controller;

import com.baizhi.zjh.entity.UserMsg;
import com.baizhi.zjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("allUsersMsg")
    public List<UserMsg> allUsersMsg() {
        return userService.allUsersForMap();
    }
    @RequestMapping("allUserNumbers")
    public Map<String, Integer> allUserNumbers(){
        List<Integer> days = new ArrayList<>();
        days.add(1);
        days.add(2);
        days.add(3);
        return userService.dataOfRegisterPeople(days);}
}
