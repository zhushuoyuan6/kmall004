package com.kgc.kmall.swaggerdemo.controller;

import com.kgc.kmall.swaggerdemo.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口",description = "提供用户相关的Rest API")
public class UserController {
    @ApiOperation("新增用户接口")
    @PostMapping(value = "/add",produces = "application/json;charset=UTF-8")
    public boolean add(@RequestBody @ApiParam(name = "user",value = "用户对象",required = true) User user){
        return true;
    }
    @ApiOperation("根据id删除用户")
    @GetMapping("/del")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    public boolean deleteById(int id){
        return true;
    }
    @ApiOperation("动态查询用户并分页")
    @GetMapping("/select")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="用户编号",required = false),
            @ApiImplicitParam(name = "name",value="用户姓名",required = false),
            @ApiImplicitParam(name = "pageIndex",value="页码",required = false),
            @ApiImplicitParam(name = "pageSize",value="页面行数",required = false),
    })
    public List<User> select(int id, String name, int pageIndex, int pageSize){
        return new ArrayList<User>();
    }
    @ApiOperation("根据id查询用户")
    @GetMapping("/getUserById")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数问题"),
            @ApiResponse(code = 404,message = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(code = 405,message = "请求类型不正确"),
            @ApiResponse(code = 500,message = "后端程序出错")
    })
    public User getUserById(int id){
        return new User();
    }
}
