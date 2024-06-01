package com.learning.main;
import java.sql.*;

import com.learning.util.JdbcUtility;

public class LaunchBatch 
{
 public static void main(String args[])
 {
	 Connection connect=null;
	 PreparedStatement pstmt=null;
	 
	    try {
			connect=JdbcUtility.getDBConnection();
			if(connect!=null)
			{
				String sql="update student set city=? where id=?";
				pstmt=connect.prepareStatement(sql);
			}
			
			pstmt.setString(1, "Chennai");
			pstmt.setInt(2, 3);
			pstmt.addBatch();
			
			pstmt.setString(1, "Patna");
			pstmt.setInt(2, 4);
			pstmt.addBatch();
			
			pstmt.setString(1, "Bhopal");
			pstmt.setInt(2, 5);
			pstmt.addBatch();
			
		     pstmt.executeBatch();
	
			System.out.println("Record updated successfully..");
			
			JdbcUtility.closeAllConnection(connect, pstmt, null);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}catch (Exception e) {
		
			e.printStackTrace();
		}
	 
 }
}
