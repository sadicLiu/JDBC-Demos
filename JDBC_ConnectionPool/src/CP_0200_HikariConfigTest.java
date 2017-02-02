package com.ace.connectionpool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by liuhy on 2017/2/1.
 * This clas shows how to use HikariConfig class
 */
public class CP_0200_HikariConfigTest
{
    public static void main(String[] args)
    {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("1111");
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        try
        {
            conn = ds.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery("select * from dept");

            while (rs.next())
            {
                System.out.println(rs.getString("dname"));
                System.out.println(rs.getString("location"));
                System.out.println(rs.getInt("deptno"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
