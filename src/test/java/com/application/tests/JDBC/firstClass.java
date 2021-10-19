package com.application.tests.JDBC;

import javafx.beans.binding.ObjectExpression;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class firstClass {

    String dbUrl = "jdbc:oracle:thin:@3.84.129.57:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");
        resultSet.next();
        String first_name = resultSet.getString("first_name");
        System.out.println(first_name);
        String first_nameAsString = resultSet.getString(1);
        System.out.println(first_name);

        resultSet.close();
        statement.close();
        connection.close();



    }

}
