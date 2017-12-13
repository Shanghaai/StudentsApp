package com.jspiders.StudentsApp.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ConnectionPoolManager 
{
	private ArrayList<Connection> pool = new ArrayList<Connection>();
	private int pool_size = 20;
	private String driverClass = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/studentsapp_db";
	private String userNM = "j2ee";
	private String password = "j2ee";
	private static ConnectionPoolManager instance = null;
	
	public static ConnectionPoolManager getInstance() 
	throws Exception
	{
		if(instance==null){
			instance = new ConnectionPoolManager();
		}
		return instance;
	}
	
	private ConnectionPoolManager() 
	throws Exception
	{
		System.out.println("Creating the Connection Pool for the First Time ...");
		
		//1. Load the Driver
		Class.forName(driverClass).newInstance();
		
		for(int i=0; i<pool_size; i++){
			//2. Get the DB Connection via Driver
			Connection con = DriverManager.getConnection(dbUrl, userNM, password);
			pool.add(con);
		}
	}//End of Constructor
		
	public Connection getConnectionFromPool()
	{
		System.out.println("Pool Size before getting the Connection : "+pool.size());
		
		Connection con = pool.get(0);
		pool.remove(0);
		
		System.out.println("Pool Size after getting the Connection : "+pool.size());
		
		return con;
	}//End of getConnectionFromPool
	
	public void returnConnectionToPool(Connection con)
	{
		System.out.println("Pool Size before returning the Connection : "+pool.size());
		
		pool.add(con);
		
		System.out.println("Pool Size after returning the Connection : "+pool.size());
	}//End of returnConnectionToPool
		
}//End of Class
