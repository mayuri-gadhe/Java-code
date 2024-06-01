package com.learning.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.learning.util.JdbcUtility;

public class LaunchBatchInsert {
	public static void main(String[] args) {
		 Connection connect=null;
		 PreparedStatement pstmt=null;
		 Scanner scan=new Scanner(System.in);
		 
		    try {
				connect=JdbcUtility.getDBConnection();
				if(connect!=null)
				{
					String sql="insert into student (id,name,age,city) values"
							+ "(?,?,?,?)";
					pstmt=connect.prepareStatement(sql);
				}
				
				System.out.println("How many records you want to update");
				int input=scan.nextInt();
				
				for(int i=1;i<=input;i++)
				{
					System.out.println("Insert " +  i + " record\n");
					System.out.println("Enter id");
					int id=scan.nextInt();
					System.out.println("Enter name");
					String name=scan.next();
					System.out.println("Enter age");
					int age=scan.nextInt();
					System.out.println("Enter city");
					String city=scan.next();
					common(id,name,age,city,pstmt);
				}
				
			     pstmt.executeBatch();
		
				System.out.println("Record updated successfully..");
				
				JdbcUtility.closeAllConnection(connect, pstmt, null);
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		    catch (Exception e) {
				
				e.printStackTrace();
			}
	 
	}

	
	public static void common(int id,String name,int age,String city,PreparedStatement pstmt)
	{
		try {
			pstmt.setInt(1,id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setString(4, city);
			pstmt.addBatch();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
}
