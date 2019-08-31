package com.licf.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * mbcc_sys_user_role
 * @author 
 */
@Data
public class UserRole implements Serializable {
    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 角色编号
     */
    private Integer roleId;

}