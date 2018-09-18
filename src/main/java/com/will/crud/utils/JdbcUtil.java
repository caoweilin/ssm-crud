package com.will.crud.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
     private static String className;
     private static String url;
     private static String user;
     private static String password;
     static{
         Properties pro=new Properties();
         InputStream in=null;
         try {
        	//Ïà¶ÔÂ·¾¶
	in = JdbcUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			
			pro.load(in);
		
			className=pro.getProperty("driverClassName");
			Class.forName(className);
			
			url=pro.getProperty("url");
			user=pro.getProperty("username");
			password=pro.getProperty("password");
		 } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		 } catch (IOException e) {
			
			e.printStackTrace();
		 } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(in!=null) in.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
     }
     

     public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	 } 
     
    
     public static void closeDb(ResultSet rs,Statement state,Connection conn){
    	try {
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	try {
			if(state!=null) state.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    	try {
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
     }
     
     public static void closeDb(Statement state,Connection conn){
    	 closeDb(null,state,conn);
      }
}
