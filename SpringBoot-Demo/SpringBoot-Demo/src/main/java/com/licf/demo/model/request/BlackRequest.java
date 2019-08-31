package com.licf.demo.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
* 类描述:
 * @ApiModelProperty(hidden = true)则页面上不展示此选项
* @author licanfeng
* @date 2019/3/12 16:21
* @version 1.0
*/
@Data
public class BlackRequest {
    @ApiModelProperty(value = "标识顺序，用来对应返回值")
    @Min(value = 10,message = "最低为10")
    @Max(value = 100,message = "最高为100")
    private Integer id;

    @Email(message = "邮件格式不正确")
    @ApiModelProperty(value = "用户ID")
    private String uniqueId;

    @ApiModelProperty(value = "设备ID")
    private String appId;

    @ApiModelProperty(value = "用户IP")
    private String ip;
}
