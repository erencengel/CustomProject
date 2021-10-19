package com.application.tests.JDBC;

import com.application.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.sql.*;

public class Bookit {

    String url = ConfigurationReader.get("dbUrl1");
    String username = ConfigurationReader.get("dbUsername1");
    String password = ConfigurationReader.get("dbPassword1");

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString(2));
        resultSet.close();
        statement.close();
        connection.close();
    }
}
