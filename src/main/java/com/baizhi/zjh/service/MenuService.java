package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> getAllMenus(Integer parent_id);
}
