package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Menu;
import com.baizhi.zjh.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.selectAll();
    }
}
