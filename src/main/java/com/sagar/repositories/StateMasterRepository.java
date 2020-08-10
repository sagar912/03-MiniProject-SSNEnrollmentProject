package com.sagar.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.entities.StateMasterEntity;

public interface StateMasterRepository extends JpaRepository<StateMasterEntity, Serializable> {

}
