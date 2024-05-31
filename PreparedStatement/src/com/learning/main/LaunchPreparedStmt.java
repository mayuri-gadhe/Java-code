package com.learning.main;
import java.sql.*;
import java.util.Scanner;

import com.learning.util.JdbcUtility;
public class LaunchPreparedStmt {
	
	public static void main(String[] args) 
	{
		
		Connection connect=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		ResultSet rs=null;
		Scanner scan=null;
		
		
		try {
			connect=JdbcUtility.getDBConnection();
			if(connect!=null)
			{
				String query="insert into student(id,name,age,city)"
						+ "values (?,?,?,?)";
				pstmt=connect.prepareStatement(query);
			}
			if(pstmt!=null) {
				scan=new Scanner(System.in);
			System.out.println("Enter id of student");
			Integer id=scan.nextInt();
			System.out.println("Enter name of student");
			String name=scan.next();
			System.out.println("Enter age of student");
			Integer age=scan.nextInt();
			System.out.println("Enter city of student");
			String city=scan.next();
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setString(4, city);
			
			int rowAffected=pstmt.executeUpdate();
			System.out.println(rowAffected+"rows updated");
			System.out.println("Data Inserted successfully");
			
			System.out.println("To see all data in student table then type yes ,if not then type no");
			String input=scan.next();
			if(input.equals("yes") || input.equals("YES") || input.equals("y") || input.equals("Y") )
			{
				LaunchRetrive.retriveData();
			}
			else
			{
			System.out.println("Thank you");
			}
			
			
			
			}
			else
			{
				System.out.println("Failed to insert");
			}
			
			JdbcUtility.closeAllResources(connect, rs,pstmt);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
