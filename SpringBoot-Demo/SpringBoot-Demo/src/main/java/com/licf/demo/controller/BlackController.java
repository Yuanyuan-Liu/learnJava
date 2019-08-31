package com.licf.demo.controller;

import com.licf.demo.common.vo.Result;
import com.licf.demo.model.User;
import com.licf.demo.model.request.UserRequest;
import com.licf.demo.model.response.UserResponse;
import com.licf.demo.service.BlackService;
import com.licf.demo.common.enums.ResultStatusCode;
import com.licf.demo.model.request.BlackRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/v1/black")
@Api(tags="羊毛党查询相关接口")
@Slf4j
public class BlackController {

    @Autowired
    private BlackService blackService;

    /**
     * 批量获取用户是否属于羊毛党
     * @return
     */
    @PostMapping("/list")
    @ApiOperation(value = "批量获取用户是否属于羊毛党", notes = "用户ID,设备ID,用户IP至少传一个")
    @RequiresRoles("admin")
    //@ApiImplicitParam(name="blackRequests", value="查询黑名单数组", required=true, paramType="query" ,allowMultiple=true, dataType = "BlackRequest[]")
    public Object list(@RequestBody BlackRequest[] blackRequests ){
        if (null == blackRequests || blackRequests.length < 1) {
            return new Result(ResultStatusCode.BAD_REQUEST);
        }
        System.out.println(Arrays.toString(blackRequests));
        return new Result(ResultStatusCode.OK, blackService.list(blackRequests));
    }

    /**
     * 测试校验框架
     */
    @PostMapping("/listByPage")
    @ApiOperation(value = "测试验证框架", notes = "用户ID,设备ID,用户IP至少传一个")
    public Object listByPage(@RequestBody @Validated BlackRequest blackRequests ) {
        return new Result(ResultStatusCode.OK, "验证成功");
    }


    /**
     * 测试Bean转Bean
     */
    @PostMapping("/beanConvertBean")
    @ApiOperation(value = "测试Bean转Bean", notes = "用户ID,设备ID,用户IP至少传一个")
    public Object beanConvertBean(@RequestBody @Validated UserRequest userRequest ) {
        log.info("userRequest:" +  userRequest);
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        //可以看到转换成功
        log.info("user:" +  user);

        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        //UserResponse 与 User中loginName属性名与类型符合 转换成功 id虽然属性名相同，但类型不同，故转换失败
        log.info("userResponse:" +  userResponse);

        return new Result(ResultStatusCode.OK, userResponse);
    }
}
