package com.sagar.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.entities.SSAPortalEntity;
import com.sagar.entities.StateMasterEntity;
import com.sagar.exceptions.NoSsnFoundException;
import com.sagar.model.SSAEnrollmentRequest;
import com.sagar.repositories.SSAPortalRepository;
import com.sagar.repositories.StateMasterRepository;

@Service
public class SSAPortalServiceImpl implements SSAPortalService {

	@Autowired
	private SSAPortalRepository ssaPortalRepository;

	@Autowired
	private StateMasterRepository stateMasterRepository;

	@Override
	public Map<Integer, String> getAllStates() {
		// create map object
		Map<Integer, String> stateMap = new LinkedHashMap();
		// get all records using findAll()
		List<StateMasterEntity> stateList = stateMasterRepository.findAll();

		// get stateid and name by using forEach() method
		stateList.forEach(stateEntity -> {
			stateMap.put(stateEntity.getStateId(), stateEntity.getStateName());
		});
		return stateMap;
	}

	@Override
	public Long ssaEnrollment(SSAEnrollmentRequest request) {

		SSAPortalEntity ssaPortalEntity = new SSAPortalEntity();
		BeanUtils.copyProperties(request, ssaPortalEntity);

		SSAPortalEntity saveEntity = ssaPortalRepository.save(ssaPortalEntity);

		if (saveEntity != null) {
			return saveEntity.getSsn();
		}
		return null;
	}

	@Override
	public SSAEnrollmentRequest checkEnrollment(Long ssn, String stateName) {
		SSAEnrollmentRequest request=new SSAEnrollmentRequest();
		SSAPortalEntity entity = ssaPortalRepository.findBySsnAndStateName(ssn, stateName);
		                          
		if(entity!=null) {
			BeanUtils.copyProperties(entity, request);
			return request;
		}
		throw new NoSsnFoundException("No ssn number found");
	}

}
