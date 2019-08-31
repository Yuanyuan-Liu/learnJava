package com.licf.demo.controller;

import com.licf.demo.common.enums.ResultStatusCode;
import com.licf.demo.common.vo.Result;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/common")
@RestController
@Api(tags="授权相关接口")
public class CommonController {

    /**
     * 未授权跳转方法
     * @return
     */
    @GetMapping("/unauth")
    public Result unauth(){
        SecurityUtils.getSubject().logout();
        return new Result(ResultStatusCode.UNAUTHO_ERROR);
    }

    /**
     * 被踢出后跳转方法
     * @return
     */
    @GetMapping("/kickout")
    public Result kickout(){
        return new Result(ResultStatusCode.INVALID_TOKEN);
    }

}
