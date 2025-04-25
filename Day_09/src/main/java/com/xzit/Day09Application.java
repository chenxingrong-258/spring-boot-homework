package com.xzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xzit.generate.mapper")
public class Day09Application {

	public static void main(String[] args) {
		SpringApplication.run(Day09Application.class, args);
	}

}
