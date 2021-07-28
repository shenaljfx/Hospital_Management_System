package com.hospital.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.hospital.model.ElectiveAdmitPatient;
import com.hospital.model.EmergencyPatient;
import com.hospital.model.Patient;
import com.hospital.model.Payment;

public interface IPatientService {
		
	/*
	  Add patient for patient table & Emergency table
	*/
	public void addPatient(EmergencyPatient patient);
	
	/*
	  Add patient for patient table & ElectiveAdmission table
	*/
	public void addPatient(ElectiveAdmitPatient patient);
	
	/*
	 * Get a particular Patient 
	*/
	public Patient getPatientByID(String patientId);
	
	/*
	 * Get all list of patients
	*/
	public ArrayList<Patient> getPatients();
	
	/*
	 * Update existing patient
	*/
	public void updatePatient(String patientId, Patient patient);

	/*
	 * Remove existing patient
	*/
	public void dischargePatient(String patientId);
	
	/*
	 * get patient id List
	 */
	public ArrayList<String> getPatientIDs();
	
	/*
	 * get patient symptoms details
	 */
	
	public String[] getSymptoms(String patientId); 

	
	
	
}


