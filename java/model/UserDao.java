package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: model.UserDao
 * Package: PACKAGE_NAME
 * Description:
 *  针对用户表提供的基本操作
 *  由于此处没写注册功能，也就不必搞 add
 *  也没有用户删号功能，也就不必 delete
 * @Author 全家乐
 * @Create 2023/8/3 10:26
 * Version 1.0
 */
public class UserDao {
    // 1、根据 userId 来查用户信息
    public User selectById(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            // 2、构造 SQL
            String sql = "select * from user where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            // 3、执行 SQL
            resultSet = statement.executeQuery();
            // 4、遍历结果集合
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getNString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 2、根据 username 来查用户信息（登录的时候）
    public User selectByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            // 2、构造 SQL
            String sql = "select * from user where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            // 3、执行 SQL
            resultSet = statement.executeQuery();
            // 4、遍历结果集合
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getNString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
}
