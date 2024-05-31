package com.telusko.jdbc.main;
import java.sql.*;

import com.telusko.jdbc.util.JdbcUtility;


public class LaunchUsingExecute {
	public static void main(String[] args) {
		Connection connect=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			connect=JdbcUtility.getDBConnection();
			if(connect!=null)
				stmt=connect.createStatement();
			if(stmt!=null)
			{
			boolean status=stmt.execute("update student set age=30 where id=2");
				//boolean status=stmt.execute("select * from student");
			
			if(status)
			{
				System.out.println("Wirte ResultSet to get the data:");
				rs=stmt.getResultSet();
				if(rs!=null)
				{
				System.out.println("ID \t NAME\t  AGE \t CITY");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+ "\t" + rs.getString(2) +"\t" + rs.getInt(3)
					+ "\t" +rs.getString(04));
				}
				}
				
			}
			else
			{
				System.out.println("How many rows affected..");
				int rowAffected=stmt.getUpdateCount();
				System.out.println("Data Updated successfully");
				System.out.println(rowAffected + "rows are affected");
			}
			
			}
			JdbcUtility.closeAllResources(connect, stmt, rs);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	}

}
