package com.xzit.gene.service;

import com.xzit.gene.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 86198
* @description 针对表【user】的数据库操作Service
* @createDate 2025-03-20 16:52:10
*/
public interface UserService extends IService<User> {
    User login(User user);

}
