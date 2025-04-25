package com.xzit.gene.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzit.gene.entity.User;
import com.xzit.gene.service.UserService;
import com.xzit.gene.mapper.UserMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author 86198
* @description 针对表【user】的数据库操作Service实现
* @createDate 2025-03-20 16:52:10
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    private UserMapper mapper;


    @Override
    public User login(User user) {
        return mapper.login(user);
    }
}




