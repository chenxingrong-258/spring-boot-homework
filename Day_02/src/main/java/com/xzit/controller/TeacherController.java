package com.xzit.controller;

import com.xzit.model.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(tags = "教师信息表")
public class TeacherController {
    @GetMapping()
    @ApiOperation("查询全部数据")
    public Object select(){
        List<Teacher> list = new ArrayList<>();
        list.add(new Teacher(1,"张三",23));
        list.add(new Teacher(2,"李四",43));
        list.add(new Teacher(3,"王五",37));
        list.add(new Teacher(4,"赵六",26));
        return list;
    }
    @GetMapping("/{id}")
    @ApiOperation("按照id查询数据")
    public Object selectById(@PathVariable int id){
        return new Teacher(1,"张三",23);

    }
    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除数据")
    public Object deleteById(@PathVariable int id){
        return "已删除给定路径的id为"+id+"的对象";
    }

    @PutMapping()
    @ApiOperation("更新数据")
    public Object update(@RequestBody Teacher teacher){
        return teacher;
    }

    @PostMapping()
    @ApiOperation("新增数据")
    public Object insert(@RequestBody Teacher teacher){
        return teacher;
    }
}
