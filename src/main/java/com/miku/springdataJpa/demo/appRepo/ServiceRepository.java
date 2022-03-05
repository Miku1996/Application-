package com.miku.springdataJpa.demo.appRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miku.springdataJpa.demo.dao.ApplicationCodeDto;
import com.miku.springdataJpa.demo.dao.ApplicationCodeServiceCodeDto;
import com.miku.springdataJpa.demo.entities.App.Applicaiton;
import com.miku.springdataJpa.demo.entities.App.Services;
import com.miku.springdataJpa.demo.entities.App.SubApplication;
@Repository
public interface ServiceRepository extends JpaRepository<Services,Integer>{

	List<Services> findBySubApplicationCode(int subApplicationCode);
	   
		
	Services findByServiceCode(int serviceCode);
	
	
}
