package com.telusko.learning;

import java.sql.*;

public class Launch {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/telusko_db";
		String user="root";
		String password="root";
		
		Connection con=DriverManager.getConnection(url,user,password);
		
		Statement stmt=con.createStatement();
		String query="insert into student (name,age,gender,mobile,city)"
				+ "values ('Pratiksha',27,'F','9875678567','Pune')";
		System.out.println("Query working fine");
		 int rowAffected=stmt.executeUpdate(query);
		 if(rowAffected!=0)
			 System.out.println("Check DB ...Data Added successfully");
		 else
			 System.out.println("Failed to add");
		 stmt.close();
		 con.close();
	}

}
