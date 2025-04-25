package com.xzit;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestGenerator {
    @Test
    public void generator(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis?serverTimezone=GMT%2B8",
                        "root", "2673253736Cxr")
                .globalConfig(builder -> {
                    builder.author("teacher_shi") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(".\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.xzit") // 设置父包名
                            .moduleName("generate");// 设置父包模块名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("article") // 设置需要生成的表名
                            //.addTablePrefix("i_", "c_") // 设置过滤表前缀
                            .entityBuilder().enableLombok() //开启lombok
                            .enableChainModel()//开启链式编程
                            .controllerBuilder().enableRestStyle();//开启restController
// .logicDeletePropertyName("deleted")
// .logicDeleteColumnName("deleted");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
