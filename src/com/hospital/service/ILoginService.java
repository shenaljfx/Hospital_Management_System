/**
 * 
 */
package com.hospital.service;

import com.hospital.model.Login;

/**
 * @author user
 *
 */
public interface ILoginService {
	
	/*
	 * validate login
	 */
	public String loginValidation(Login login, String empId);
}




