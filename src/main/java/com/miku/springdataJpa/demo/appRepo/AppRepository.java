package com.miku.springdataJpa.demo.appRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miku.springdataJpa.demo.entities.App.Applicaiton;

@Repository
public interface AppRepository extends JpaRepository<Applicaiton, Integer> {
	
	 
	Applicaiton findByApplicationCode(int  applicationCode);
	   
	
	}
