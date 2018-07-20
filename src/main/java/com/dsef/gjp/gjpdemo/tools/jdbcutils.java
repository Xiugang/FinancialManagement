package com.dsef.gjp.gjpdemo.tools;

import org.apache.commons.dbcp.BasicDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author D.S.E.F
 * @date 2018/7/16
 */
public class jdbcutils {
    private static BasicDataSource datasource = new BasicDataSource();
    static{
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
        datasource.setUsername("root");
        datasource.setPassword("root");
        System.out.println("连接成功");
        datasource.setMaxActive(10);
        datasource.setMaxIdle(5);
        datasource.setMinIdle(2);
        datasource.setInitialSize(10);
    }
    public static DataSource getDataSource(){
        return datasource;
    }
}
