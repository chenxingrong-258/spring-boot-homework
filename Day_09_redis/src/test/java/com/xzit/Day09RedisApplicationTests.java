package com.xzit;

import com.xzit.gene.entity.User;
import com.xzit.gene.mapper.UserMapper;
import com.xzit.gene.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Day09RedisApplicationTests {
    @Resource
    private UserService service;
    @Resource
    private UserMapper mapper;

    @Test
    void contextLoads() {
    }
    @Test
    public void test() {
        User user = new User(0,"admin","123");
        User login = service.login(user);
        System.out.println(login);
    }
    @Test
    public void test2() {
        User user = new User(0,"admin","123");
        User login = mapper.login(user);
        System.out.println(login);
    }
    @Test
    public void test3() {
        List<User> list = service.list();
        list.forEach(System.out::println);
    }

}
