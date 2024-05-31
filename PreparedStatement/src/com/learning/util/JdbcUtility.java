package com.learning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtility {

	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) 
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
	
	public static void closeAllResources(Connection connect,ResultSet rs,PreparedStatement pstmt) throws SQLException
	{
		if(connect!=null)
		connect.close();
		if(pstmt!=null)
			pstmt.close();
		if(rs!=null )
		rs.close();
	}
	
}
