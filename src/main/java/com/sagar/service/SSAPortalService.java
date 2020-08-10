package com.sagar.service;

import java.util.Map;

import com.sagar.model.SSAEnrollmentRequest;

public interface SSAPortalService {

	public Map<Integer,String> getAllStates();
	
	public Long ssaEnrollment(SSAEnrollmentRequest request);
	
	public SSAEnrollmentRequest checkEnrollment(Long ssn,String stateName);
	
	
}
