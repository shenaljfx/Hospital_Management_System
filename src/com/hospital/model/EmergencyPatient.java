package com.hospital.model;

public class EmergencyPatient extends Patient {
	private String condition;
	
	private String emergencyType;
	
	public EmergencyPatient() {
		super();
		
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the emergencyType
	 */
	public String getEmergencyType() {
		return emergencyType;
	}

	/**
	 * @param emergencyType the emergencyType to set
	 */
	public void setEmergencyType(String emergencyType) {
		this.emergencyType = emergencyType;
	}

}
