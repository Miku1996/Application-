package com.miku.springdataJpa.demo.appRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miku.springdataJpa.demo.dao.SubApplicationDto;
import com.miku.springdataJpa.demo.entities.App.SubApplication;

@Repository
public interface subApplicationRepository extends JpaRepository<SubApplication, Integer>{
 
	List<SubApplication> findByApplicationCode(int applicationCode);
	
	SubApplication findBySubApplicationCode(int subApplicationCode);

}
