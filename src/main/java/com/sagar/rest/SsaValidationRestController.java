package com.sagar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.model.SSAEnrollmentRequest;
import com.sagar.service.SSAPortalService;

@RestController
public class SsaValidationRestController {
    
	@Autowired
	private SSAPortalService ssaPortalService;
	
	@GetMapping(value = "/validateSSn/{ssn}/{state}",
			       produces="application/json")
	public SSAEnrollmentRequest validate(@PathVariable("ssn") String ssn, @PathVariable("state") String state) {
	          
		SSAEnrollmentRequest enrollmentRequest= ssaPortalService.checkEnrollment(Long.parseLong(ssn), state);
		
		return enrollmentRequest;
	}
}
