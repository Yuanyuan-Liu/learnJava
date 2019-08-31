package com.example.demo.dao;
import com.example.demo.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户服务数据接口类
 *
 * @author 杨高超
 * @since 2018-03-12
 */

@Repository
public interface UserDao extends JpaRepository<UserDO, Long> {
    UserDO findByAccount(String account);
}