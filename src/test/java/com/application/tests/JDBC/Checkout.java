package com.application.tests.JDBC;

import com.application.tests.TestBaseForDataBase;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class Checkout extends TestBaseForDataBase {

    ResultSet resultSet;

    @Test
    public void test1() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select first_name,last_name,email,salary" +
                " from employees where rownum<6");
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int columnNumber = resultSetMetaData.getColumnCount();

        //resultSet.next();

        List<Map<String,Object>> list = new ArrayList<>();

        while (resultSet.next()){

        Map<String,Object> map = new LinkedHashMap<>();

            for(int i=1;i<=columnNumber;i++){
                map.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
            }

            list.add(map);

        }

        resultSet.close();

        System.out.println(list.toString());

    }

}
