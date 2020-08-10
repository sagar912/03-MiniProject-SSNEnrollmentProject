package com.sagar.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sagar.entities.SSAPortalEntity;

public interface SSAPortalRepository extends JpaRepository<SSAPortalEntity, Serializable> {

	public SSAPortalEntity findBySsnAndStateName(Long ssn,String stateName);
}
