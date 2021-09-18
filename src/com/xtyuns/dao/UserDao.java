package com.xtyuns.dao;

import com.xtyuns.pojo.User;

import java.sql.SQLException;

public interface UserDao {
    User getUser(String username, String password) throws SQLException;
}
