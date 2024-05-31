package com.telusko.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LaunchJDBC2 {
public static void main(String[] args) throws Exception
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	String url="jdbc:mysql://localhost:3306/telusko_db";
	String user="root";
	String password="root";
	
	Connection con=DriverManager.getConnection(url,user,password);
	Statement stmt=con.createStatement();
	
	String sql="update student set city='nashik' where id=3";
	System.out.println("Query working fine");
	int rowAff=stmt.executeUpdate(sql);
	
	if(rowAff!=0)
		System.out.println("Updated successfully");
	else
		System.out.println("not updated..");
	 
	stmt.close();
	con.close();
	
}
}
