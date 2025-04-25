package com.xzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.xzit.generate.mapper")
public class Day08Application {

    public static void main(String[] args) {
        SpringApplication.run(Day08Application.class, args);
    }

}
