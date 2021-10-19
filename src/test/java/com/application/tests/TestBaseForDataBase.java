package com.application.tests;

import com.application.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBaseForDataBase {

    String url = ConfigurationReader.get("dbUrl");
    String username = ConfigurationReader.get("dbUsername");
    String password = ConfigurationReader.get("dbPassword");
    public Connection connection;
    public Statement statement;

    @BeforeMethod
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection(url,username,password);
        statement = connection.createStatement();
    }

    @AfterMethod
    public void tearDown() throws SQLException {
        connection.close();
        statement.close();
    }

}
