package com.learning.main;
import java.sql.*;

import com.learning.util.JdbcUtility;
public class LaunchRetrive {
	public static void retriveData()
	{
		Connection connect=null;
		
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		
		try {
			connect=JdbcUtility.getDBConnection();
			if(connect!=null)
			{
					String sql="SELECT * FROM student";
					pstmt=connect.prepareStatement(sql);
				    rs=pstmt.executeQuery();
				      if(rs!=null)
				       {
				          System.out.println("ID \t NAME \t AGE \t CITY");
				          {
				        	  while(rs.next())
				        	  {
				        		  System.out.println(rs.getInt(1)+"\t"+rs.getString(2) +
				        				  "\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t");
				        	  }
				         
				          }
				          }
				      
				}
				JdbcUtility.closeAllResources(connect, rs, pstmt);
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
