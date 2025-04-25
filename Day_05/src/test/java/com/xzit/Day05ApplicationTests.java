package com.xzit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzit.entity.Emp;
import com.xzit.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Day05ApplicationTests {
    @Resource
    private EmpMapper empMapper;

    @Test
    void contextLoads() {
    }
    @Test
    public void test1() {
        empMapper.insert(new Emp(0,"张三","123","123",19,"男","法务部",0,0,"南京市"));
        empMapper.insert(new Emp(0,"李四","1234","1234",20,"女","市场部",0,0,"南京市"));
        empMapper.insert(new Emp(0,"王五","12345","12345",25,"女","销售部",0,0,"吉林市"));
        empMapper.insert(new Emp(0,"赵六","123456","123456",61,"女","市场部",0,0,"南京市"));

    }
    @Test
    public void test2(){
        List<Emp> list = empMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void test3(){
        UpdateWrapper<Emp> wrapper = new UpdateWrapper<>();
        wrapper.set("dept_name", "销售部").eq("dept_name", "市场部");
        empMapper.update(null,wrapper);
    }

    @Test
    public void test4(){
        UpdateWrapper<Emp> wrapper = new UpdateWrapper<>();
        wrapper.set("status",1).between("age",30,50);
        empMapper.update(null,wrapper);
    }

    @Test
    public void test5(){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.ge("age",60).eq("gender","男");
        empMapper.delete(wrapper);
    }

    @Test
    public void test6(){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.between("age",22,30);
        List<Emp> list = empMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test7(){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_name","市场部").or().eq("dept_name","销售部").eq("gender","女");
        List<Emp> list = empMapper.selectList(wrapper);
    }

    @Test
    public void test8(){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("addr","长春").eq("status",1);
        List<Emp> list = empMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test9(){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        wrapper.eq("login_name","admin").and(i->i.eq("gender","男").or().eq("dept_name","人事部"));
        List<Emp> list = empMapper.selectList(wrapper);
        list.forEach(System.out::println);

    }
    @Test
    public void test10(){
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        Page<Emp> page = new Page<>(1,5);
        wrapper.orderBy(true,false,"age");
        List<Emp> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("总记录数："+page.getTotal());

    }

}
