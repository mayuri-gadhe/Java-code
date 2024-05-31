package com.telusko.jdbc;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LaunchJDBC3 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/telusko_db";
		String user="root";
		String password="root";
		
		Connection con=DriverManager.getConnection(url,user,password);
		
		Statement stmt=con.createStatement();
		
		String query="update student set city='Thane' where id=3";
		System.out.println("Query working fine..");
		
		int rowAff=stmt.executeUpdate(query);
		
		if(rowAff!=0)
			System.out.println("table alter successfully");
		else
			System.out.println("failed to alter");
		
		stmt.close();
		con.close();
		
		
		
	}

}
