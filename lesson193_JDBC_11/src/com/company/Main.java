package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String userName = "root";
        String password = "root";
//        String connectionURL = "jdbc:mysql://localhost:3306/mydbtest";
        String connectionURL = "jdbc:mysql://localhost:3306/mydbtest?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());﻿
        try(Connection conn = DriverManager.getConnection(connectionURL, userName, password);
            Statement statement = conn.createStatement()) {
            statement.executeUpdate("drop table users");
            statement.executeUpdate("create table users (id MEDIUMINT NOT NULL  AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30), dt DATE, PRIMARY KEY (id))");
            statement.executeUpdate("insert into users (name, password) VALUES ('Alex','123')");
            statement.executeUpdate("insert into users (name, password) VALUES ('James','321')");

            CallableStatement callableStatement = conn.prepareCall("{call getCount()}");
            boolean hasResults = callableStatement.execute();
            while (hasResults) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1   ));
                }
                hasResults = callableStatement.getMoreResults();
            }
        }
    }
}