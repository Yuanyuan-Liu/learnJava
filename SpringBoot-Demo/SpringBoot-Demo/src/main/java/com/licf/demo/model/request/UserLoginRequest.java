package com.licf.demo.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 类描述:
 * @ApiModelProperty(hidden = true)则页面上不展示此选项
* @author licanfeng
* @date 2019/3/12 16:21
* @version 1.0
*/
@Data
public class UserLoginRequest {
    @ApiModelProperty(value = "用户名",example = "licf")
    private String loginName;

    @ApiModelProperty(value = "密码",example = "123456")
    private String pwd;
}
