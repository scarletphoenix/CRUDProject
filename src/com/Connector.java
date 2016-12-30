package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	
	static Connection con;
	public  Connector() throws Exception{
		
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver Loaded");
	con = DriverManager.getConnection("jdbc:mysql://localhost/test","","");
	System.out.println("Connection established");
	
	}
}
