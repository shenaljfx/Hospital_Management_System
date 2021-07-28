package com.hospital.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mysql.*;

import com.hospital.servlet.*;
import com.hospital.model.ElectiveAdmitPatient;
import com.hospital.model.EmergencyPatient;
import com.hospital.model.Patient;
import com.hospital.model.Payment;
import com.hospital.service.PatientServiceImple;
import com.hospital.util.CommonUtilities;
import com.hospital.util.DBConnection;




public class PatientServiceImple implements IPatientService{
	private static Connection con;
	
	private PreparedStatement ps;
	
	
	
		@Override
	public void addPatient(ElectiveAdmitPatient patient) {
		String  PID = CommonUtilities.generateIDs(getPatientIDs());
		
		try {
			con = DBConnection.getDBConnection();
			
			//First store the general  details of the elective admission patient in the patient database
			ps = con.prepareStatement("insert into patient values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			con.setAutoCommit(false);
			
			patient.setPatientId(PID);
			ps.setString(1, patient.getPatientId());
			ps.setString(2, patient.getName());
			ps.setString(3, patient.getAddress());
			ps.setString(4, patient.getDOB());
			ps.setString(5, patient.getGender());
			ps.setString(6, patient.getEmail());
			ps.setString(7, patient.getJoiningDate());
			ps.setString(8, patient.getPhoneNumber());
			ps.setString(9, patient.getWardNo());
			ps.setString(10,  "Admitted");
		 
			ps.executeUpdate();
			con.commit();
			
			//Second store the specific details for the elective admission patients in the elective_admit_patient
			ps = con.prepareStatement("insert into elective_admit_patient values(?, ?, ?, ?, ?)");
			con.setAutoCommit(false);
			
			ps.setString(1, patient.getPatientId());
			ps.setString(2, patient.getReason());
			ps.setString(3, patient.getDoctorName());
			ps.setString(4, patient.getWardNo());
			ps.setString(5, patient.getWardType());
			
			ps.executeUpdate();
			con.commit();
			
			//Third store the patient symptoms
			ps = con.prepareStatement("insert into symptoms values(?, ?, ?, ?)");
			con.setAutoCommit(false);
			
			ps.setString(1, patient.getPatientId());
			ps.setString(2, patient.getSymptoms());
			ps.setString(3, patient.getSinceWhen());
			ps.setString(4, patient.getDisease());
			
			ps.executeUpdate();
			con.commit();
			
			//call reserveBed() function CommonUtilities
			CommonUtilities.reserveBed(patient.getWardNo());
			
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
	public void addPatient(EmergencyPatient patient) {
		String  PID = CommonUtilities.generateIDs(getPatientIDs());
		
		try {
			con = DBConnection.getDBConnection();
			
			//First store the general details of the emergency patient in the patient database 
			ps = con.prepareStatement("insert into patient values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			con.setAutoCommit(false);
			
			patient.setPatientId(PID);
			ps.setString(1, patient.getPatientId());
			ps.setString(2, patient.getName());
			ps.setString(3, patient.getAddress());
			ps.setString(4, patient.getDOB());
			ps.setString(5, patient.getGender());
			ps.setString(6, patient.getEmail());
			ps.setString(7, patient.getJoiningDate());
			ps.setString(8, patient.getPhoneNumber());
			ps.setString(9, patient.getWardNo());
			ps.setString(10,  "Admitted");
		 
			ps.executeUpdate();
			con.commit();
			
			//Second store the specific details of the emergency patient in the emergency database
			ps = con.prepareStatement("insert into emergencypatient values(?, ?, ?, ?)");
			
			ps.setString(1, patient.getPatientId());
			ps.setString(2, patient.getCondition());
			ps.setString(3, patient.getEmergencyType());
			ps.setString(4, patient.getWardNo());
			
			ps.executeUpdate();
			con.commit();
			
			//Third store the patient symptoms
			ps = con.prepareStatement("insert into symptoms values(?, ?, ?, ?)");
			con.setAutoCommit(false);
			
			ps.setString(1, patient.getPatientId());
			ps.setString(2, patient.getSymptoms());
			ps.setString(3, patient.getSinceWhen());
			ps.setString(4, patient.getDisease());
			
			ps.executeUpdate();
			con.commit();
			
			//call reserveBed() function CommonUtilities
			CommonUtilities.reserveBed(patient.getWardNo());
			
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
	public Patient getPatientByID(String patientId) {
		return actionOnPatient(patientId).get(0);
	}

	@Override
	public ArrayList<Patient> getPatients() {
		return actionOnPatient(null);
	}

	@Override
	public void updatePatient(String patientId, Patient patient) {
		
		if (patientId != null && !patientId.isEmpty()) {
			
			try {
				con = DBConnection.getDBConnection();
				ps = con.prepareStatement("update patient set name = ?, address = ?, email = ?, phoneNumber = ?, wardNo = ? where patientId = ?");
				ps.setString(1, patient.getName());
				ps.setString(2, patient.getAddress());
				ps.setString(3, patient.getEmail());
				ps.setString(4, patient.getPhoneNumber());
				ps.setString(5, patient.getWardNo());
				ps.setString(6, patientId);
				
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
	public void dischargePatient(String patientId) {
			String ward = null;
		
			try {
				con = DBConnection.getDBConnection();
				ps = con.prepareStatement("select * from patient where patientId = ?");
				ps.setString(1, patientId);
				
				ResultSet resultSet = ps.executeQuery();
				
				if(resultSet.next()) {
					ward = resultSet.getString(9);
					
				}
				
				if(ward.equals("W004")) {
					ps = con.prepareStatement("delete from emergencypatient where patientId = ?");
					ps.setString(1, patientId);
					
					ps.executeUpdate();
					
				}else {
					ps = con.prepareStatement("delete from elective_admit_patient where patientId = ?");
					ps.setString(1, patientId);
					
					ps.executeUpdate();
				}
				
				ps = con.prepareStatement("delete from symptoms where patientId = ?");
				ps.setString(1, patientId);
				ps.executeUpdate();
				
				ps = con.prepareStatement("update patient set status = 'Discharged' where patientId = ?");
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

		


	@Override
	public ArrayList<String> getPatientIDs() {
		ArrayList<String> al = new ArrayList<String>();
		
		try {
			con = DBConnection.getDBConnection();
			ps = con.prepareStatement("select patientId from Patient");
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				al.add(res.getString(1));
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
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
		
		return al;
	}
	
	private ArrayList<Patient> actionOnPatient(String patientID) {

		ArrayList<Patient> patientList = new ArrayList<Patient>();
		try {
			con = DBConnection.getDBConnection();
			
			//get a single patient
			if (patientID != null && !patientID.isEmpty()) {
				
				ps = con.prepareStatement("select * from patient where patientId = ?");
				ps.setString(1, patientID);
			}
			//get all patients
			else {
				ps = con.prepareStatement("select * from patient");
			}
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				Patient patient = new EmergencyPatient();
				patient.setPatientId(resultSet.getString(1));
				patient.setName(resultSet.getString(2));
				patient.setAddress(resultSet.getString(3));
				patient.setDOB(resultSet.getString(4));
				patient.setGender(resultSet.getString(5));
				patient.setEmail(resultSet.getString(6));
				patient.setJoiningDate(resultSet.getString(7));
				patient.setPhoneNumber(resultSet.getString(8));
				patient.setWardNo(resultSet.getString(9));
				patientList.add(patient);
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
		return patientList;
	}

	@Override
	public  String[] getSymptoms(String patientId) {
		String arr[] = new String[4];
		
		try {
			con = DBConnection.getDBConnection();
			
			//get a single patient
			ps = con.prepareStatement("select * from symptoms where patientId = ?");
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
	
	

	
		
}
