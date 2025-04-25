package com.xzit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class Day02Application {

    public static void main(String[] args) {
        SpringApplication.run(Day02Application.class, args);
    }

}
