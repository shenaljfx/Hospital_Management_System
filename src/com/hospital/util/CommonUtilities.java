package com.hospital.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;



public class CommonUtilities {
	public static final Properties properties = new Properties();
	
	private static Connection con;
	
	private static PreparedStatement ps;
		
	static {
		try {
			
			// Read the property only once when load the class
			properties.load(CommonUtilities.class.getResourceAsStream("config.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//PatientId generation code
	
	public static String generateIDs(ArrayList<String> arrayList) {
		
		String pid;
		int next = arrayList.size();
		next++;
		pid = "PID" + next;
		if(arrayList.contains(pid)) {
			next++;
			pid = "PID" + next;
		}
		return pid;
	}
	
	public static void reserveBed(String wardNo) {
		
		
		try {
			con = DBConnection.getDBConnection();
			
			//Increase noOfReservedBeds by 1
			ps = con.prepareStatement("update ward set noOfReservedBeds = (noOfReservedBeds + 1) where wardNo = ? ");
			ps.setString(1, wardNo);
			ps.executeUpdate();
			
			
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
		
	}
	
}
