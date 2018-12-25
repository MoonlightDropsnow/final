package com.baizhi.zjh.mapper;

import com.baizhi.zjh.entity.User;
import com.baizhi.zjh.entity.UserMsg;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public List<UserMsg> queryAllGroupByCity();
    public Integer queryUserNumberByTimeInterval(Integer days);
}
