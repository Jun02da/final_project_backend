package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	 final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	 final String DB_URL = "jdbc:mariadb://localhost:3306/project";

	 public Connection open() {
		 Connection conn = null;
		 try {
			 Class.forName(JDBC_DRIVER);
			 conn = DriverManager.getConnection(DB_URL, "kosmo", "1234");
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return conn;
	 }
	 
	 public List<User> getAll() throws Exception {
		 Connection conn = open();
		 List<User> userList = new ArrayList<>();
		 String sql = "select user_email, user_gender, user_password from user";
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 ResultSet rs = pstmt.executeQuery();
		
		 try(conn; pstmt; rs) {
			 while(rs.next()) {
				 User u = new User();
				 u.setEmail(rs.getString("user_email"));
				 u.setGender(rs.getString("user_gender"));
				 u.setPassword(rs.getString("user_password"));				
				 userList.add(u);
			 }
			 return userList;			
		 }
	}	 
}
