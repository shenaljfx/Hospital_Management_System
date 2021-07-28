/**
 * 
 */
package com.hospital.model;


public class ElectiveAdmitPatient extends Patient {
	private String reason;
	
	private String doctorName;
	
	private String wardType;
	
	public ElectiveAdmitPatient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * @param doctorName the doctorName to set
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * @return the wardType
	 */
	public String getWardType() {
		return wardType;
	}

	/**
	 * @param wardType the wardType to set
	 */
	public void setWardType(String wardType) {
		this.wardType = wardType;
	}

	
	
	
	
	
}
