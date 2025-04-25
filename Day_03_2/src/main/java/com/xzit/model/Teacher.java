package com.xzit.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;
@Data
@Component
@ConfigurationProperties(prefix = "com.xzit.model.teacher")
public class Teacher {
    private String name;
    private String gender;
    private int age;
    private Set<Student> students;

}
