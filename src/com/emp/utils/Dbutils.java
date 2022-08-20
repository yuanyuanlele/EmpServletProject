package com.emp.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Dbutils {
    private static DruidDataSource ds;
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    static {
        Properties properties=new Properties();
        InputStream inputStream=Dbutils.class.getResourceAsStream("/database.properties");
        try {
            properties.load(inputStream);
            ds= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection(){
        Connection connection=threadLocal.get();
        if (connection==null){
            try {
                connection= ds.getConnection();
                threadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void begin(){
        Connection connection=null;
        try {
            connection=getconnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(){
        Connection connection=null;
        connection=getconnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeall(connection,null,null);
        }
    }

    public static void rollback(){
        Connection connection=null;
        connection=getconnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeall(connection,null,null);
        }
    }

    public static void closeall(Connection connection,Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
                threadLocal.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
