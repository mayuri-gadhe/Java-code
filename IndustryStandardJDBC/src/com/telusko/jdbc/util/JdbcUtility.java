package com.telusko.jdbc.util;

import java.sql.*;


public class JdbcUtility {
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		    } 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/telusko_db";
		String user="root";
		String password="root";
		
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void closeAllResources(Connection connect,Statement stmt,ResultSet rs) throws SQLException
	{
		if(connect!=null)
			connect.close();
		if(stmt!=null)
			stmt.close();
		if(rs!=null)
			rs.close();
	}

}
