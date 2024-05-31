package com.telusko.jdbc.main;

import java.sql.*;

import com.telusko.jdbc.util.JdbcUtility;

public class LaunchJDBCAll {
	
	public static void main(String arg[])
	{
		Connection connect=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			connect=JdbcUtility.getDBConnection();
			if(connect!=null)
				stmt=connect.createStatement();
			if(stmt!=null)
				//Using executeQuery
				rs=stmt.executeQuery("SELECT * FROM employee");	
			if(rs!=null)
			{
				System.out.println("ID \t NAME \t AGE \t CITY");
				while(rs.next())
			
			{
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + " \t" + rs.getInt(3) + "\t"
						+ rs.getString(4) );
			}
			}
			JdbcUtility.closeAllResources(connect, stmt, rs);
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
