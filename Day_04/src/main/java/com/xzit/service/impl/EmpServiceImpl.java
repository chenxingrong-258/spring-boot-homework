package com.xzit.service.impl;

import com.xzit.mapper.EmpMapper;
import com.xzit.model.Emp;
import com.xzit.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;
    @Override
    public List<Emp> findAll() {
        return empMapper.selectAll();
    }

    @Override
    public int save(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public int deleteId(int id) {
        return empMapper.deleteById(id);
    }

    @Override
    public int updateId(Emp emp) {
        return empMapper.updateById(emp);
    }

    @Override
    public Emp findById(int id) {
        return empMapper.selectById(id);
    }


}
