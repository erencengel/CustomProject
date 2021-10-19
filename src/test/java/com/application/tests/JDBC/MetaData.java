package com.application.tests.JDBC;

import com.application.tests.TestBaseForDataBase;
import org.testng.annotations.Test;

import java.sql.*;

public class MetaData extends TestBaseForDataBase {

    ResultSet resultSet;

    @Test
    public void dataBaseMetaData() throws SQLException {

        resultSet = statement.executeQuery("select * from employees");

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("databaseMetaData.getDatabaseProductName() = " + databaseMetaData.getDatabaseProductName());
        System.out.println("databaseMetaData.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("databaseMetaData.getDriverName() = " + databaseMetaData.getDriverName());
        System.out.println("databaseMetaData.getDriverVersion() = " + databaseMetaData.getDriverVersion());

        resultSet.close();
    }

    @Test
    public void resultSetMetaData() throws SQLException {
        resultSet = statement.executeQuery("select * from employees");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        System.out.println("resultSetMetaData.getColumnName(1) = " + resultSetMetaData.getColumnName(1));
        System.out.println("resultSetMetaData.getColumnName(2) = " + resultSetMetaData.getColumnName(2));
        System.out.println("resultSetMetaData.getColumnCount() = " + resultSetMetaData.getColumnCount());
        System.out.println("resultSetMetaData.getColumnTypeName(2) = " + resultSetMetaData.getColumnTypeName(2));
        System.out.println("resultSetMetaData.isNullable(3) = " + resultSetMetaData.isNullable(3));
        System.out.println("resultSetMetaData.getColumnCount() = " + resultSetMetaData.getColumnCount());
        System.out.println("resultSetMetaData.getColumnName(4) = " + resultSetMetaData.getColumnName(4));

        resultSet.close();

    }


}
