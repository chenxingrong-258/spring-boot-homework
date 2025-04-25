package com.xzit.service;

import com.xzit.model.Emp;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmpService {
    List<Emp> findAll();
    int save(Emp emp);
    int deleteId(int id);
    int updateId(Emp emp);
    Emp findById(int id);
}
