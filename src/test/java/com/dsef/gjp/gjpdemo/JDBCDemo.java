package com.dsef.gjp.gjpdemo;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author D.S.E.F
 * @date 2018/7/19
 */
public class JDBCDemo {
    public static void main(String[] args){
        BasicDataSource dataSource = new BasicDataSource();
        //连接数据库的4个最基本信息,通过对象方法setXXX设置进来
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        try{
            //调用对象方法getConnection获取数据库的连接
            Connection con = dataSource.getConnection();
            System.out.println(con);
            System.out.println("连接成功");
        }catch(SQLException ex){
            //			System.out.println(ex);
            ex.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }
    }
}
