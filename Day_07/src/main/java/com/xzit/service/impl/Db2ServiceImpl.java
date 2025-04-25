package com.xzit.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzit.mapper.Db2Mapper;
import com.xzit.model.Db2;
import com.xzit.service.Db2Service;
@DS("slave")
public class Db2ServiceImpl extends ServiceImpl<Db2Mapper, Db2> implements Db2Service {
}
