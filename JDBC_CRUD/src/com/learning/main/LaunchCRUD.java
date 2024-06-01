package com.learning.main;

import java.sql.*;
import java.util.Scanner;
import com.learning.util.JDBCUtility;

public class LaunchCRUD {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			Connection connect = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			System.out.println("****  Welcome in CRUD program organised by MAYURI  ****\n");
			System.out.println("1.Display all data in table");
			System.out.println("2.I want to delete some data");
			System.out.println("3.I want to Insert Some data");
			System.out.println("4.I want to update some data");
			System.out.println("Choose any one option from above list,PLEASE type option number");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				try {
					connect = JDBCUtility.getDBConnection();
					if (connect != null) {
						String sql = "SELECT * FROM student";
						pstmt = connect.prepareStatement(sql);
						rs = pstmt.executeQuery();
						if (rs != null) {
							System.out.println("ID \t NAME \t AGE \t CITY");
							{
								while (rs.next()) {
									System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3)
											+ "\t" + rs.getString(4) + "\t");
								}
							}
						}
					}
					JDBCUtility.closeAllResources(connect, rs, pstmt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				check();
				break;
			case 2:
				try {
					connect = JDBCUtility.getDBConnection();
					if (connect != null) {
						String sql = "delete from student where id=?";
						pstmt = connect.prepareStatement(sql);
					}
					if (pstmt != null) {
						System.out.println("Enter id whose record you want to delete:");
						Integer id = scan.nextInt();
						pstmt.setInt(1, id);

						int rowAffect = pstmt.executeUpdate();
						if (rowAffect > 0) {
							System.out.println("Record Deleted successfully");
						} else {
							System.out.println("Failed to delete");
						}
					}
					JDBCUtility.closeAllResources(connect, rs, pstmt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				check();
				break;
			case 3:
				try {
					connect = JDBCUtility.getDBConnection();
					if (connect != null) {
						String query = "insert into student(id,name,age,city)" + "values (?,?,?,?)";
						pstmt = connect.prepareStatement(query);
					}
					if (pstmt != null) {
						scan = new Scanner(System.in);
						System.out.println("Enter id of student");
						Integer id = scan.nextInt();
						System.out.println("Enter name of student");
						String name = scan.next();
						System.out.println("Enter age of student");
						Integer age = scan.nextInt();
						System.out.println("Enter city of student");
						String city = scan.next();

						pstmt.setInt(1, id);
						pstmt.setString(2, name);
						pstmt.setInt(3, age);
						pstmt.setString(4, city);

						int rowAffected = pstmt.executeUpdate();
						if (rowAffected > 0) {
							System.out.println("Data Inserted successfully");
						} else {
							System.out.println("Failed to insert");
						}
					}
					JDBCUtility.closeAllResources(connect, rs, pstmt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				check();
				break;
			case 4:
				try {
					connect = JDBCUtility.getDBConnection();
					if (connect != null) {
						String sql = "update student set name=? where id=?";
						pstmt = connect.prepareStatement(sql);
					}
					if (pstmt != null) {
						System.out.println("Enter new name which you want to add:");
						String name = scan.next();
						System.out.println("Enter id whose record you want to update:");
						Integer id = scan.nextInt();

						pstmt.setString(1, name);
						pstmt.setInt(2, id);

						int rowAffect = pstmt.executeUpdate();
						if (rowAffect > 0) {
							System.out.println("Record Updated successfully");
						} else {
							System.out.println("Failed to delete");
						}
					}
					JDBCUtility.closeAllResources(connect, rs, pstmt);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				check();
				break;

			default:
				System.out.println("\n");
				System.out.println("\tPlease Enter Valid option\n");

			}

		}
	}

	public static void check() {
		Scanner scan = new Scanner(System.in);
		System.out.println("If you want to exit then press y,if not press any other key");
		if ((scan.next()).equals("y")) {
			System.out.println("\n");
			System.out.println("*** THANK YOU FOR VISITING CRUD PROGRAM ***");
			System.exit(0);
		}

	}
}