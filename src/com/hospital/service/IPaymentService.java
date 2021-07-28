/**
 * 
 */
package com.hospital.service;

import com.hospital.model.Payment;

/**
 * @author user
 *
 */
public interface IPaymentService {

	/*
	 * Add patient Insurance details to payment table 
	 */
	public void addPatientPayment(Payment payment, String str);
	
	/*
	 * get patient Insurance details
	 */
	
	public String[] getPaymentDetails(String patientId);
	
	/*
	 * update patient payment methods
	 */
	
	public void updatePatientPayment(String patientId, Payment payment);
	
	/*
	 * delete patient payment methods
	 */
	
	public void deletePatientPayment(String patientId);
}
