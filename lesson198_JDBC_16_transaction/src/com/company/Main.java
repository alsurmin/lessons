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
        Connection conn = null;
        try {conn = DriverManager.getConnection(connectionURL, userName, password);

            Statement statement = conn.createStatement();
                conn.setAutoCommit(false);

                statement.executeUpdate("drop table users");
                statement.executeUpdate("create table users (id MEDIUMINT NOT NULL  AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30), dt DATE, PRIMARY KEY (id))");
                statement.executeUpdate("insert into users (name, password) VALUES ('Alex','123')");

                Savepoint savepoint = conn.setSavepoint();

                statement.executeUpdate("insert into users (name, password) VALUES ('James','321')");
                statement.executeUpdate("insert into users (name, password) VALUES ('Bob','444')");
                statement.executeUpdate("insert into users (name, password) VALUES ('Sam','444')");

//            conn.rollback(savepoint);
                conn.commit();
//            conn.releaseSavepoint(savepoint);

            } catch (SQLException e) {
            conn.rollback();
        }



   }
}