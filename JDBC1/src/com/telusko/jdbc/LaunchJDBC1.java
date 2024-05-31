package com.telusko.jdbc;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class LaunchJDBC1 {
	public static void main(String arg[]) throws Exception
	{
	//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	//Establish connection
		String url="jdbc:mysql://localhost:3306/telusko_db";
		String user="root";
		String password="root";
		
		Connection connect=DriverManager.getConnection(url,user,password);
		
	// statement is used to carry sql query
		
		Statement stmt=connect.createStatement();
		System.out.println("Statement object is ready");
	
	//ExecuteQuery is used for retriving the details
  
		 ResultSet rs=stmt.executeQuery("SELECT * FROM student");
		 
		 System.out.println("We have got result set");
		 System.out.println("ID \t NAME \t AGE \t GENDER \t MOBILE \t CITY");
		 while(rs.next())
		 {
			 System.out.println(rs.getInt(1) + "\t" + rs.getString(2)+ "\t" + rs.getInt(3)
			 + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" +rs.getString(6));
		 }
		 
		 rs.close();
		 stmt.close();
		 connect.close();
		
		 
		
		
		
		
		
		
		
		
		
	}

}
