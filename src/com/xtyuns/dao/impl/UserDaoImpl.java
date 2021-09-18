package com.xtyuns.dao.impl;

import com.xtyuns.dao.UserDao;
import com.xtyuns.pojo.User;
import com.xtyuns.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = new QueryRunner(JDBCUtil.dataSource);

    @Override
    public User getUser(String username, String password) throws SQLException {
        String sql = "select id, username, password from user where username=? and password=? limit 1";
        User ret = qr.query(sql, new BeanHandler<>(User.class), username, password);
        return ret;
    }
}
