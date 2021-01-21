package com.jason.utils;

import java.sql.*;

/**
 * @author：Jason
 * @date：2021/1/21 11:57
 * @email：1129847330@qq.com
 * @description: 将JDBC规范下相关对象创建于销毁的封装
 * JDBC开发步骤：
 * 1、注册数据库服务器提供的Driver接口实现类
 * 2、创建一个连接通道交给Connection接口的实例对象【JDBCConnection】管理
 * 3、创建一个交通工具交给PrepareStatement接口的实例对象【JDBC4PrepareStatement】管理
 * 4、由交通工具在Java工程与数据库服务器之间进行传输，推送SQL命令并带回执行结果
 * 5、交易结束后，销毁相关的资源【Connection，PrepareStatement，ResultSet】
 */
public class JDBCUtils {
    Connection connection;
    PreparedStatement ps;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jason", "root", "123");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public PreparedStatement getPrepareStatement(String sql) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                ps = connection.prepareStatement(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return ps;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close();
    }
}