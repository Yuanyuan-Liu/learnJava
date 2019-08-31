package com.licf.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * mbcc_sys_role
 * @author 
 */
@Data
public class Role implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 英文名称
     */
    private String enname;

    /**
     * 数据范围
     */
    private String dataScope;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 是否系统数据
     */
    private String isSys;

    /**
     * 是否可用
     */
    private Integer useable;

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