package com.licf.demo.controller;

import com.licf.demo.model.User;
import com.licf.demo.model.request.UserRequest;
import com.licf.demo.service.UserService;
import com.licf.demo.common.enums.ResultStatusCode;
import com.licf.demo.common.vo.Result;
import com.licf.demo.util.MD5Util;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/user")
@Api(tags="用户增删改查相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findList")
    public Object list(){
        return new Result(ResultStatusCode.OK, userService.list());
    }

    @PostMapping("/addUser")
    public Object addUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setLoginName(userRequest.getLoginName());
        user.setName(userRequest.getName());
        user.setPassword(MD5Util.getSaltMD5(userRequest.getPassword()));
        user.setRoleId(userRequest.getRoleId());
        user.setDelFlag("0");
        //user.setLoginFlag("1");
        Date date = new Date();
        user.setCreateDate(date);
        user.setUpdateDate(date);

        return userService.addUser(user);
    }



    @PostMapping("/deleteUser")
    public Object deleteUser(@RequestBody Integer userId) {
        User user = new User();
        user.setDelFlag("1");
        Date date = new Date();
        user.setUpdateDate(date);
        user.setUpdateBy(0);
        user.setId(userId);
        return userService.updateUser(user);
    }
}
