package com.xzit.gene.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzit.gene.entity.User;
import com.xzit.gene.service.UserService;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")

public class UserController {
    @Resource
    private UserService service;
    @Resource
    private RedisTemplate redisTemplate;
    @GetMapping("/{name}/{password}")
    public Object login(@PathVariable String name, @PathVariable String password) {
        String key = "user:" + name;
        Object o = redisTemplate.opsForValue().get(key);
        if (o == null) {
            System.out.println("在数据库上查询");
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("name", name).eq("password", password);
            User login = service.getOne(wrapper);
            if (login != null) {
                System.out.println("登入成功");
                redisTemplate.opsForValue().set("user:"+name, password);
            }else {
                if (redisTemplate.opsForValue().get("lockey")!=null) {
                    System.out.println("您在3分钟内失败了3次，请经过30分钟后再尝试");
                } else {
                    boolean existence = (redisTemplate.opsForValue().get("attempt")!=null);
                    if (!existence) {
                        redisTemplate.opsForValue().set("attempt", 1,180, TimeUnit.SECONDS);
                        System.out.println("您已经失败一次,还可以尝试两次");
                    } else {
                        if (redisTemplate.opsForValue().get("attempt").equals(2)) {
                            redisTemplate.opsForValue().set("lockey", "locked",1800,TimeUnit.SECONDS);
                            System.out.println("您已失败三次,在30分钟内无法再登入");
                        } else {
                            redisTemplate.opsForValue().increment("attempt", 1);
                            System.out.println("您已经失败两次,还可以尝试一次");
                        }
                    }
                }
            }
        }else {
            System.out.println("在redis缓存上查询,登入成功");
        }
        return "123";

    }

}
