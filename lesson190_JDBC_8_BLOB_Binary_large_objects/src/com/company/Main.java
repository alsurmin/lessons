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
            statement.executeUpdate("create table users (id MEDIUMINT NOT NULL  AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30), img BLOB, PRIMARY KEY (id))");
//            statement.executeUpdate("insert into Users  (name, password) values('Alex', '123')");
//            statement.executeUpdate("insert into Users set name = 'Solomon Kein', password = '321' ");

            BufferedImage image = ImageIO.read(new File("Beach.jpg"));
            Blob blob = conn.createBlob();
            try(OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(image, "jpg", outputStream);
            }

            PreparedStatement preparedStatement = conn.prepareStatement("insert into users (name, img) values (?,?)");
            preparedStatement.setString(1, "inferno");
            preparedStatement.setBlob(2,blob);
            preparedStatement.execute();

            /*
            Read file prom DB
             */
            ResultSet resultSet = statement.executeQuery("select img from users");
            while(resultSet.next()) {
                Blob blob2 = resultSet.getBlob("img");
                BufferedImage image1 = ImageIO.read(blob2.getBinaryStream());
                File outputFile = new File("saved.png");
                ImageIO.write(image, "png", outputFile);
            }
        }
    }
}
