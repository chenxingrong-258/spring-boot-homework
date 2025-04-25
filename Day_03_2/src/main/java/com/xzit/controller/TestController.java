package com.xzit.controller;

import com.xzit.model.Student;
import com.xzit.model.Teacher;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("test")
public class TestController {
    @Resource
    private Environment env;
    @Resource
    private Teacher teacher;

    @GetMapping("/1")
    public String showYml() {
        return teacher.toString();
    }
    @GetMapping("/2")
    public String showGrades(){
        Set<Student> students = teacher.getStudents();
        for (Student student : students) {
            System.out.println(student.avgGrade());
        }
        return "hello";
    }
    @GetMapping("/3")
    public String showGrades2(){
        int total = 0;
        Set<Student> students = teacher.getStudents();
        for (Student student : students) {
            Integer chinese = student.getChinese();
            total = total+chinese;
        }
        System.out.println(total/students.size());
        return "hello";
    }
}
