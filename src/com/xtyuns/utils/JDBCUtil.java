package com.xtyuns.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtil {
    public static DataSource dataSource;

    static {
        InputStream ris = JDBCUtil.class.getClassLoader().getResourceAsStream("mysql.properties");
        Properties properties = new Properties();
        try {
            properties.load(ris);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
