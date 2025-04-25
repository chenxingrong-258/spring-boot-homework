package com.xzit.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Random;


@Data
@Component

public class Student {
    private String name;
    private String gender;
    private Integer age = new Random().nextInt(4) + 15;
    private Integer chinese = new Random().nextInt(11) + 80;
    private Integer math = new Random().nextInt(11) + 70;
    private Integer english = new Random().nextInt(11) + 90;
    public Integer avgGrade() {
        return (chinese+math+english)/3;
    }

}
