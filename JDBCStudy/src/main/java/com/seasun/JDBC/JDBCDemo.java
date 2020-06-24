package com.seasun.JDBC;

import java.sql.*;
import java.util.HashMap;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mybatis_test?useSSL=false";
        String user = "root";
        String password = "----------";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement(
                    "select * from user"
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            conn.commit();
            while (resultSet.next()) {

                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("sex"));
                System.out.println(resultSet.getString("age"));
                System.out.println(resultSet.getDate("birthday"));
                System.out.println("-------------------");
            }
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException er) {
                er.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
