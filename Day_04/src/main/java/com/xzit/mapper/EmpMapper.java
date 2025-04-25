package com.xzit.mapper;

import com.xzit.model.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface EmpMapper {
    List<Emp> selectAll();
    int insert(Emp emp);
    int deleteById(int id);
    int updateById(Emp emp);
    Emp selectById(int id);
}
