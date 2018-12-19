package com.baizhi.zjh.controller;

import com.baizhi.zjh.entity.Menu;
import com.baizhi.zjh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("allMenus")
    private List<Menu> allMenus(Integer parent_id) {
        return menuService.getAllMenus(parent_id);
    }
}
