package com.xzit.gene.mapper;

import com.xzit.gene.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 86198
* @description 针对表【user】的数据库操作Mapper
* @createDate 2025-03-20 16:52:10
* @Entity gene.entity.User
*/
public interface UserMapper extends BaseMapper<User> {
    User login(User user);

}




