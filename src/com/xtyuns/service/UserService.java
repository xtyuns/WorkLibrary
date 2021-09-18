package com.xtyuns.service;

import com.xtyuns.pojo.User;

import java.sql.SQLException;

public interface UserService {
    User login(String username, String password) throws SQLException;
}
