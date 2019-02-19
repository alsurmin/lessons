package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "root";
//        String connectionURL = "jdbc:mysql://localhost:3306/mydbtest";
        String connectionURL = "jdbc:mysql://localhost:3306/mydbtest?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());﻿
        try(Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        Statement statement = conn.createStatement()) {
            statement.executeUpdate("drop table users");
            statement.executeUpdate("create table Users (id MEDIUMINT NOT NULL  AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30) NOT NULL, PRIMARY KEY (id))");
            statement.executeUpdate("insert into Users  (name, password) values('Alex', '123')");
            statement.executeUpdate("insert into Users set name = 'Solomon Kein', password = '321' ");
//            ResultSet resultSet = statement.executeQuery("select * from Users");
//            while(resultSet.next()) {
//                System.out.println(resultSet.getInt(1));
//                System.out.println(resultSet.getString("name"));
//                System.out.println("--------------");
//            }
//            ResultSet r2 = statement.executeQuery("select name from books where id = 1");
//            while(r2.next()) {
//                System.out.println(r2.getString(1));
//            }
//            String userId = "1";
            String userId = "1 or 1 = 1";
//            ResultSet resultSet = statement.executeQuery("select * from Users where id = "+ userId);
//            while (resultSet.next()) {
//                System.out.println("userName: "+ resultSet.getString("name"));
//                System.out.println("userPassword: "+ resultSet.getString("password"));
//            }

            PreparedStatement preparedStatement = conn.prepareStatement("select * from Users where id = ?");
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("userName: "+ resultSet.getString("name"));
                System.out.println("userPassword: "+ resultSet.getString("password"));
            }
        }
    }
}
