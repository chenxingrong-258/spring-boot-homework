package com.xzit.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.model.Emp;
import com.xzit.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("emp")
@Api(tags = "员工信息")
public class EmpController {
    @Resource
    private EmpService empService;
    @GetMapping
    @ApiOperation("显示全部数据")
    public Object selectAll() {
        List<Emp> all = empService.findAll();
        return all;
    }
    @PostMapping
    @ApiOperation("插入一条数据")
    public Object insert(@RequestBody Emp emp) {
        return empService.save(emp);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除数据")
    public Object delete(@PathVariable int id) {
        return empService.deleteId(id);
    }
    @PutMapping
    @ApiOperation("更新数据")
    public Object update(@RequestBody Emp emp) {
        return empService.updateId(emp);
    }
    @GetMapping("/{start}/{size}")
    @ApiOperation("分页显示数据")
    public Object selectByPage(@PathVariable int start, @PathVariable int size) {
        PageHelper.startPage(start, size);
        List<Emp> all = empService.findAll();
        PageInfo<Emp> info = new PageInfo<>(all);
        return info;
    }
    @GetMapping("/{id}")
    @ApiOperation("根据id查询数据")
    public Object selectById(@PathVariable int id) {
        return empService.findById(id);
    }

}
