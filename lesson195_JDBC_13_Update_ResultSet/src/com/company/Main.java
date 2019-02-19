package com.company;

import javax.imageio.ImageIO;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Main {
    static String userName = "root";
    static String password = "root";
//    String connectionURL = "jdbc:mysql://localhost:3306/mydbtest";
    static String connectionURL = "jdbc:mysql://localhost:3306/mydbtest?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        ResultSet resultSet = getData();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
        }

        CachedRowSet cachedRowSet = (CachedRowSet) resultSet;
        cachedRowSet.setUrl(connectionURL);
        cachedRowSet.setUsername(userName);
        cachedRowSet.setPassword(password);
//        cachedRowSet.setCommand("select * from users where id = ?");
//        cachedRowSet.setInt(1,2);
//        cachedRowSet.setPageSize(20);
//        cachedRowSet.execute();
//        do {
//            while (cachedRowSet.next()) {
//                System.out.println(cachedRowSet.getInt("id"));
//                System.out.println(cachedRowSet.getString("name"));
//            }
//        } while (cachedRowSet.nextPage());



}

static ResultSet getData() throws SQLException {
    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());﻿

    try(Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        Statement statement = conn.createStatement()) {
        statement.executeUpdate("drop table users");
        statement.executeUpdate("create table users (id MEDIUMINT NOT NULL  AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30), dt DATE, PRIMARY KEY (id))");
        statement.executeUpdate("insert into users (name, password) VALUES ('Alex','123')");
        statement.executeUpdate("insert into users (name, password) VALUES ('James','321')");

        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet cachedRowSet = factory.createCachedRowSet();

        Statement statement2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement2.executeQuery("select * from users");
        cachedRowSet.populate(resultSet);
        return cachedRowSet;
    }
}

}