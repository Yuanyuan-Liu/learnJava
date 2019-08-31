package com.licf.demo.model.response;

import lombok.Data;

/**
 * 类描述: 此类主要是用来说明 返回类的位置
 * return new Result(ResultStatusCode.OK, new Test());
 * @author licanfeng
 * @date 2019/4/4 16:14
 * @version 1.0
 */
@Data
public class UserResponse {
    private Long id;
    private String loginName;
    private String age;
}
