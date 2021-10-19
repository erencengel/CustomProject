package com.application.tests.JDBC;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;

public class SecondClass {

    String dbUrl = "jdbc:oracle:thin:@3.84.129.57:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from departments");
        resultSet.next();

        Map<String,Object> map = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();

            map.put("department_id", resultSet.getString(1));
            map.put("department_name", resultSet.getString(2));
            map.put("manager_id", resultSet.getString(3));
            map.put("location_id", resultSet.getString(4));
            list.add(map);
            System.out.println(list.get(0).get("department_id"));

        resultSet.next();

            map.put("department_id", resultSet.getString(1));
            map.put("department_name", resultSet.getString(2));
            map.put("manager_id", resultSet.getString(3));
            map.put("location_id", resultSet.getString(4));
            list.add(map);
        System.out.println(list.get(1).get("department_id"));
        System.out.println(list.toString());


        System.out.println(map.toString());


        resultSet.close();
        statement.close();
        connection.close();

    }

}
