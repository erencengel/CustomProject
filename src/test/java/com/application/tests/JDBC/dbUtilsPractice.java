package com.application.tests.JDBC;

import com.application.utilities.DBUtils;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class dbUtilsPractice {

    @Test
    public void test1(){
        DBUtils.createConnection();
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap("select first_name,last_name,salary from employees" +
                " where rownum<6");
        System.out.println(queryResultMap.toString());
        DBUtils.destroy();
    }

    @Test
    public void test2(){
        DBUtils.createConnection();
        Map<String, Object> rowMap = DBUtils.getRowMap("select * from employees");
        System.out.println(rowMap.toString());
        DBUtils.destroy();
    }

}
