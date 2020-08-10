package com.sagar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.model.SSAEnrollmentRequest;
import com.sagar.service.SSAPortalService;

@RestController
public class SSAEnrollmentRestController {

	@Autowired
	private SSAPortalService ssaPortalService;

	@PostMapping(value="/ssaEnrollment",
			   consumes="application/json")
	
	public ResponseEntity<String> enroll(@RequestBody SSAEnrollmentRequest request){
		ResponseEntity<String> response=null;
		
		    Long ssnNumber = ssaPortalService.ssaEnrollment(request);
		    
		    String body="your ssn Enrollment completed sucessfully.Your ssn: "+ssnNumber;
		    
		    response=new ResponseEntity<>(body,HttpStatus.CREATED);
		    
		    return response;
	}

}
