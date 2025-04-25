package com.xzit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xzit.mapper.Db1Mapper;
import com.xzit.mapper.Db2Mapper;
import com.xzit.model.Db1;
import com.xzit.model.Db2;
import com.xzit.myEnum.statusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Day07ApplicationTests {
    @Resource
    private Db1Mapper mapper;
    @Resource
    private Db2Mapper mapper1;

    @Test
    void contextLoads() {
    }
    //Db1
    @Test
    public void test1() {
        List<Db1> db1s = mapper.selectList(null);
        db1s.forEach(System.out::println);
    }
    @Test
    public void test2() {
        Db1 db1 = new Db1();
        db1.setName("1234").setPassword("1234").setStatus(statusEnum.ACTIVE);
        mapper.insert(db1);
    }
    @Test
    public void test3() {
        Db1 db1 = new Db1();
        UpdateWrapper<Db1> wrapper = new UpdateWrapper<>();
        wrapper.eq("name",1234).set("name",123);
        db1.update(wrapper);
    }
    //Db2
    @Test
    public void test4() {
        QueryWrapper<Db2> wrapper = new QueryWrapper<>();
        wrapper.eq("name","张三");
        Db2 db2 = mapper1.selectOne(wrapper);
        db2.setBalance(db2.getBalance()+500);
        mapper1.updateById(db2);

    }

}
