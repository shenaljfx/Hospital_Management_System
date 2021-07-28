package com.hospital.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hospital.model.Login;
import com.hospital.util.DBConnection;

public class LoginServiceImple implements ILoginService{
	private static Connection con;
	
	private PreparedStatement ps;

	@Override
	public String loginValidation(Login login, String empId) {
			String eid;
			String userName;
			String password;
			String eType;
			String status = "invalid";
		
			try {
				
				
				con = DBConnection.getDBConnection();
							 
				ps = con.prepareStatement("select * from employee where empId = ?");
				ps.setString(1, empId);
				
				ResultSet resultSet = ps.executeQuery();
				
				while (resultSet.next()) {
					eid = resultSet.getString(1);
					userName = resultSet.getString(2);
					password = resultSet.getString(3);
					eType = resultSet.getString(4);
					
					
					if(login.getUsername().equals(userName) && login.getPassword().equals(password)){
						
						status = eType;
					}
					
				
				}
				
				
				
							
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				if(con == null) {
					System.out.println("ha");
				}
				e.printStackTrace();
			}finally {
				try {
					if(ps != null) {
						ps.close();
					}
					if(con != null) {
						con.close();
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			return status;
			
		}
	
}
