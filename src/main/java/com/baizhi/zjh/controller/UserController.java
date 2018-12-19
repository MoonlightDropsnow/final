package com.baizhi.zjh.controller;

import com.baizhi.zjh.entity.User;
import com.baizhi.zjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(User user) {
        userService.login(user);
        return "main/main";
    }

    @RequestMapping("validate")
    public String validate() {
        return null;
    }
}
