package com.licf.demo.service;

import com.licf.demo.model.Role;
import com.licf.demo.dao.RoleDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {
    @Resource
    private RoleDAO roleDAO;

    public List<Role> findByUserid(Integer userId){
        return roleDAO.findByUserId(userId);
    }
}
