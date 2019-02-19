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

        try (Connection conn = DriverManager.getConnection(connectionURL, userName, password);

            Statement statement = conn.createStatement()){
            conn.setAutoCommit(false);

            statement.addBatch("drop table if exists users");
            statement.addBatch("create table if not exists users (id MEDIUMINT NOT NULL  AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30), dt DATE, PRIMARY KEY (id))");
            statement.addBatch("insert into users (name, password) VALUES ('Alex','123')");
            statement.addBatch("insert into users (name, password) VALUES ('James','321')");
            statement.addBatch("insert into users (name, password) VALUES ('Bob','444')");
            statement.addBatch("insert into users (name, password) VALUES ('Sam','444')");

            statement.executeBatch();
            conn.commit();

//            System.out.println(statement.executeBatch().length);
//            if (statement.executeBatch().length >= 2) {
//                conn.commit();
//            }else {
//                conn.rollback();
//            }

        }
    }
}