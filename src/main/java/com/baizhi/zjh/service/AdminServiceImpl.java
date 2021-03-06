package com.baizhi.zjh.service;

import com.baizhi.zjh.entity.Admin;
import com.baizhi.zjh.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin getOne(Admin admin){
        return adminMapper.selectOne(admin);
    }
}
