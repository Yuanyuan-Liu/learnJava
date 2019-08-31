package com.licf.demo.common.vo;

import java.io.Serializable;
import java.util.List;
/**
* 类描述: 主要是用来减少PageHelper字段
* @author licanfeng
* @date 2019/3/12 18:08
* @version 1.0
*/
public class PageInfoResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;
    //结果集
    private List<T> list;
}
