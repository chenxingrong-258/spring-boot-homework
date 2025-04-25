package com.xzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.xzit.gene.mapper")
public class Day09RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day09RedisApplication.class, args);
    }

}
