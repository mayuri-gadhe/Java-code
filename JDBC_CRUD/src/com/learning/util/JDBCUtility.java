package com.learning.util;

import java.util.*;
import java.sql.*;

public class JDBCUtility {
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
