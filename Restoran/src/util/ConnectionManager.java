package util;

import java.sql.*;

public class ConnectionManager {
	
	static Connection con = null;
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran","root","root");
		}catch(Exception e) {}
	}
	public static Connection getConnection(){
		return con;
	}
}
