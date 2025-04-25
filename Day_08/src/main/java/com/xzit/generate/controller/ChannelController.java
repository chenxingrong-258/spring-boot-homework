package com.xzit.generate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzit.generate.entity.Channel;
import com.xzit.generate.service.IChannelService;
import com.xzit.generate.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author teacher_shi
 * @since 2025-03-18
 */
@RestController
@RequestMapping("/generate/channel")
@Api(tags = "频道管理")
public class ChannelController {
    @Resource
    private IChannelService channelService;
    @GetMapping
    @ApiOperation("查询全部数据")
    public Result select(){
        List<Channel> list = channelService.list();
        return Result.success().setData("list", list);
    }
    @GetMapping("/{id}")
    @ApiOperation("根据id查询数据")
    public Result selectById(@PathVariable("id") int id){
        Channel channel = channelService.getById(id);
        return Result.success().setData("channel", channel);
    }

    @PutMapping
    @ApiOperation("更新数据")
    public Result update(@RequestBody Channel channel){
        boolean b = channelService.updateById(channel);
        return b?Result.success():Result.error();
    }

    @PostMapping
    @ApiOperation("保存数据")
    public Result insert(@RequestBody Channel channel){
        boolean b = channelService.save(channel);
        return b?Result.success():Result.error();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除数据")
    public Result delete(@PathVariable int id){
        boolean b = channelService.removeById(id);
        return b?Result.success():Result.error();
    }

    @GetMapping("/{current}/{page}")
    @ApiOperation("分页查询数据")
    public Result page(@PathVariable int current, @PathVariable int page){
        Page<Channel>page1 = new Page<>(current, page);
        channelService.page(page1);
        return Result.success().setData("page", page1);
    }
}
