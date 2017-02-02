package com.ace.connectionpool;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by liuhy on 2017/2/1.
 * Note that the function of this class can be realized by above class
 */
public class CP_0300_HikariDataSourceTest
{
    public static void main(String[] args)
    {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");
        ds.setUsername("root");
        ds.setPassword("1111");

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
