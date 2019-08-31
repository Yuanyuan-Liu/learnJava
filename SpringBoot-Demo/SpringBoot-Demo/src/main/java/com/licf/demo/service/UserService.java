package com.licf.demo.service;

import com.licf.demo.model.User;
import com.licf.demo.dao.UserDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDAO userDAO;


    /**
     * 分页查询用户列表
     * @return
     */
    public PageInfo<User> list(){
        PageHelper.startPage(0, 10);
        List<User> list= userDAO.findList(null);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    public User getUserByName(String name){
        return userDAO.getByName(name);
    }

    public int addUser(User user) {
        return userDAO.insert(user);
    }

    public int updateUser(User user) {
        return userDAO.updateByPrimaryKeySelective(user);
    }
}
