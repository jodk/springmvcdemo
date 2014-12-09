package com.company.project.service;

import java.util.List;

import com.company.project.dao.UserDao;
import com.company.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在这里处理事务（数据库engine是innodb的支持）
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.getUsers();
    }

    @Transactional(readOnly = false, rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public void addUser() {
        //TODO
    }
}
