package com.jspiders.StudentsApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

public class StudentDAO 
{
	public StudentInfoBean authenticate(String regno, String password)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			//1. Load the Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2. Get the DB Connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue SQL Queries via Connection
			String query =  "  select * from 		     "+
							"  student_info si,          "+
							"  guardian_info gi,         "+
							"  student_otherinfo soi     "+
						
							" where si.regno = gi.regno  "+
							
							" and soi.regno = si.regno   "+
							" and soi.regno = ?          "+
							" and soi.passward = ?       ";
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(regno));
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			
			//4. Process the result return by sql query
			if(rs.next())
			{
				StudentInfoBean data = new StudentInfoBean();
				
				data.setRegno(rs.getInt("si.regno"));
				data.setFirstNM(rs.getString("si.firstname"));
				data.setMiddleNM(rs.getString("si.middlename"));
				data.setLastNM(rs.getString("si.lastname"));
				data.setGfirstNM(rs.getString("gi.gfirstname"));
				data.setGmiddleNM(rs.getString("gi.gmiddlename"));
				data.setGlastNM(rs.getString("gi.glastname"));
				data.setIsadmin(rs.getString("soi.isadmin"));
				data.setPassword(rs.getString("soi.passward"));
				
				return data;
			}
			else
			{
				return null;
			}
		}catch(SQLException ex){
			return null;
		}
		finally
		{
			//5. Close ALL JDBC Objects
			try 
			{
				if(con!=null){
					con.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of Authenticate
	
//---------------------------------------------------------------------------------------	
	public List<StudentInfoBean> getAllStudents()
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			//1. Load the Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2. Get the DB Connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue SQL Queries via Connection
			String query2 = "  select * from 			"+
							"  student_info si,         "+
							"  guardian_info gi         "+
							" where si.regno = gi.regno  ";
			
			System.out.println("Query 2:============================================= "+query2);
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(query2);
			
			List<StudentInfoBean> dataList = new ArrayList<StudentInfoBean>();
			
			while(rs.next())
			{
				StudentInfoBean data = new StudentInfoBean();
				data.setRegno(rs.getInt("si.regno"));
				data.setFirstNM(rs.getString("si.firstname"));
				data.setMiddleNM(rs.getString("si.middlename"));
				data.setLastNM(rs.getString("si.lastname"));
				data.setGfirstNM(rs.getString("gi.gfirstname"));
				data.setGmiddleNM(rs.getString("gi.gmiddlename"));
				data.setGlastNM(rs.getString("gi.glastname"));
				
				dataList.add(data);
			}
			return dataList;
			
		}catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}finally{
			//5. Close ALL JDBC Objects
			try 
			{
				if(con!=null){
					con.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of getAllStudents()
	
	
	public StudentInfoBean getStudentInfo(String regno)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try 
		{
			//1. Load the Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2. Get the DB Connection via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db?user=j2ee&password=j2ee";
			con = DriverManager.getConnection(dbUrl);
			
			//3. Issue SQL Queries via Connection
			String query3 = " select * from 			"+
							"  student_info si,         "+
							"  guardian_info gi,        "+
							"  student_otherinfo soi    "+
							" where si.regno = gi.regno  "+
							" and si.regno = soi.regno   "+
							" and soi.regno = ?          ";
			
			pstmt = con.prepareStatement(query3);
			pstmt.setInt(1, Integer.parseInt(regno));
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				StudentInfoBean data = new StudentInfoBean();
				data.setRegno(rs.getInt("si.regno"));
				data.setFirstNM(rs.getString("si.firstname"));
				data.setMiddleNM(rs.getString("si.middlename"));
				data.setLastNM(rs.getString("si.lastname"));
				data.setGfirstNM(rs.getString("gi.gfirstname"));
				data.setGmiddleNM(rs.getString("gi.gmiddlename"));
				data.setGlastNM(rs.getString("gi.glastname"));
				data.setIsadmin(rs.getString("soi.isadmin"));
				data.setPassword(rs.getString("soi.passward"));
				
				return data;
			}else{
				return null;
			}
		}catch(SQLException ex){
			return null;
		}finally{
			//5. Close ALL JDBC Objects
			try 
			{
				if(con!=null){
					con.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(rs!=null){
					rs.close();
}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//End of outer try-catch
	}//End of getStudentInfo()
}//End of Class
