package com.valuelabs.restfull;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static synchronized Connection getConnection(){
		Connection con = null;
	try{  
		if(con==null){
		Class.forName("com.mysql.jdbc.Driver");  
		 con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/srujana","root","root"); 
		}
		System.out.println("ConnectionFactory Class");
		}catch(Exception e){
			System.out.println(e);
		}
	return con;
	
		}  
	
}
