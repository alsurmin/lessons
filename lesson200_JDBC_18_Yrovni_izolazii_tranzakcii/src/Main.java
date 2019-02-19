import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.sql.*;

public class Main {
    static String userName = "root";
    static String password = "root";
    //        String connectionURL = "jdbc:mysql://localhost:3306/mydbtest";
    static String connectionURL = "jdbc:mysql://localhost:3306/mydbtest?verifyServerCertificate=false&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, InterruptedException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());﻿

        try (Connection conn = DriverManager.getConnection(connectionURL, userName, password);
            Statement statement = conn.createStatement()){
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            ResultSet resultSet = statement.executeQuery("select count(*) from books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }

            new OtherTransaction().start();
            Thread.sleep(2000);

            ResultSet resultSet2 = statement.executeQuery("select count(*) from books");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt(1));
            }
        }
    }

    static class OtherTransaction extends Thread {
        @Override
        public void run() {
            try (Connection conn = DriverManager.getConnection(connectionURL, userName, password);
                 Statement statement = conn.createStatement()) {

                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                statement.executeUpdate("insert into books (name) values ('new value')");
                conn.commit();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
    }

}