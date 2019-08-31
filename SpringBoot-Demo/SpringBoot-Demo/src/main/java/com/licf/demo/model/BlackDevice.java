package com.licf.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * mbcc_sys_user
 * @author 
 */
@Data
public class BlackDevice implements Serializable {
    /**
     * 设备ID
     */
    private String id;

    /**
     * 相似度
     */
    private Integer number;

    /**
     * 是否是黑名单 0：不是 1：是
     */
    private Integer isBlackParty;

    /**
     * 0：未删除 1：已删除
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtUpdate;

}