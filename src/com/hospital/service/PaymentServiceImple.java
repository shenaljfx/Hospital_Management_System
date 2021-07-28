/**
 * 
 */
package com.hospital.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.hospital.model.Payment;
import com.hospital.util.DBConnection;

/**
 * @author user
 *
 */
public class PaymentServiceImple implements IPaymentService{
	private static Connection con;
	
	private PreparedStatement ps;
	
	@Override
	public void addPatientPayment(Payment payment, String str) {
	try {
		con = DBConnection.getDBConnection();
		
		//Store the patient payment details in payment table 
		ps = con.prepareStatement("insert into payment values(?, ?, ?, ?)");
		con.setAutoCommit(false);
		
		ps.setString(1, str);
		ps.setString(2, payment.getCompany());
		ps.setString(3, payment.getPolicyNo());
		ps.setString(4, payment.getExpireDate());
		
	 
		ps.executeUpdate();
		con.commit();
		
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
	
	@Override
	public String[] getPaymentDetails(String patientId) {
		String arr[] = new String[4];
		
		try {
			con = DBConnection.getDBConnection();
			
			//get a single patient
			ps = con.prepareStatement("select * from payment where patientId = ?");
			ps.setString(1, patientId);
			
			
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				arr[0] = resultSet.getString(1);
				arr[1] = resultSet.getString(2);
				arr[2] = resultSet.getString(3);
				arr[3] = resultSet.getString(4);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	@Override
	public void updatePatientPayment(String patientId, Payment payment) {
		if (patientId != null && !patientId.isEmpty()) {
			
			try {
				con = DBConnection.getDBConnection();
				ps = con.prepareStatement("update payment set company = ?, policyNumber = ?, expiryDate = ? where patientId = ?");
				ps.setString(1, payment.getCompany());
				ps.setString(2, payment.getPolicyNo());
				ps.setString(3, payment.getExpireDate());
				ps.setString(4, patientId);
			
				
				ps.executeUpdate();

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				
				try {
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void deletePatientPayment(String patientId) {
				
		try {
			con = DBConnection.getDBConnection();
			ps = con.prepareStatement("delete from payment where patientId = ?");
			ps.setString(1, patientId);
			
			ps.executeUpdate();			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
}
