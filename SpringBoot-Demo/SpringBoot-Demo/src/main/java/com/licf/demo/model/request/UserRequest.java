package com.licf.demo.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * mbcc_sys_user
 * @author 
 */
@Data
public class UserRequest implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 登录名
     */
    @NotNull
    private String loginName;

    /**
     * 密码
     */
    @NotNull
    private String password;

    /**
     * 角色id
     */
    @NotNull
    private Integer roleId;

    /**
     * 工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 最后登陆IP
     */
    private String loginIp;

    /**
     * 最后登陆时间
     */
    private Date loginDate;

    /**
     * 是否可登录
     */
    private String loginFlag;

    /**
     * 创建者
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    private String delFlag;

}