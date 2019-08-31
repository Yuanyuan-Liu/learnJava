package com.licf.demo.controller;

import com.licf.demo.common.vo.Result;
import com.licf.demo.model.request.UserLoginRequest;
import com.licf.demo.common.enums.ResultStatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Slf4j
@Api(tags="登录登出相关接口")
public class LoginController {

    @ApiOperation(value="用户登录",notes="用户登录获取token")
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginRequest userLoginRequest) {
        String loginName = userLoginRequest.getLoginName();
        String pwd = userLoginRequest.getPwd();
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(pwd)) {
            return new Result(ResultStatusCode.NOT_PARAM_USER_OR_ERROR_PWD);
        }
        //在此捕获鉴权异常 防止异常过多 其他异常在全局异常处理
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, pwd);
            //登录不在该处处理，交由shiro处理
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            if (subject.isAuthenticated()) {
                Map<String,Object> map=new HashMap<>();
                map.put("x-auth-token",subject.getSession().getId());
                return new Result(ResultStatusCode.OK, map);
            } else {
                return new Result(ResultStatusCode.SHIRO_ERROR);
            }
        } catch (IncorrectCredentialsException |UnknownAccountException e) {
            return new Result(ResultStatusCode.NOT_EXIST_USER_OR_ERROR_PWD);
        } catch (LockedAccountException e) {
            return new Result(ResultStatusCode.USER_FROZEN);
        } catch (ShiroException e) {
            log.error("shiro 异常:{}" , e);
            return new Result(ResultStatusCode.UNAUTHO_ERROR);
        }
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return new Result(ResultStatusCode.OK);
    }
}
