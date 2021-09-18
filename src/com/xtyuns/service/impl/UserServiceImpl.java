package com.xtyuns.service.impl;

import com.mysql.jdbc.StringUtils;
import com.xtyuns.dao.UserDao;
import com.xtyuns.dao.impl.UserDaoImpl;
import com.xtyuns.pojo.User;
import com.xtyuns.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) throws SQLException {

        if (StringUtils.isEmptyOrWhitespaceOnly(username) || StringUtils.isEmptyOrWhitespaceOnly(password))
            throw new IllegalArgumentException("用户名和密码不能为空!");
        return userDao.getUser(username, password);
    }

}
