package com.miku.springdataJpa.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.miku.springdataJpa.demo.appRepo.AppRepository;
import com.miku.springdataJpa.demo.appRepo.ServiceRepository;
import com.miku.springdataJpa.demo.appRepo.subApplicationRepository;
import com.miku.springdataJpa.demo.dao.ApplicationCodeServiceCodeDto;
import com.miku.springdataJpa.demo.entities.App.Applicaiton;
import com.miku.springdataJpa.demo.entities.App.Services;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	AppRepository repository;
	
	@Autowired
	subApplicationRepository subapplicationRepository;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Test
	void contextLoads() {
	}
	@Test
	public void testfindApplicationCode() {
		    System.out.println(repository.findByApplicationCode(1002));
		    
		  }
	@Test
	public void testfindSubApplicationCode() {
		   System.out.println(subapplicationRepository.findBySubApplicationCode(1231));
		  }
	 @Test
	 public Services findByServiceCode(int serviceCode) {
		 
		return serviceRepository.findByServiceCode(12415);
	 }
	 
	 @Test
	 public void testgetapplication(int subappcode){
	 
		 Applicaiton TotalAppList = repository.findByApplicationCode(9876);
	 System.out.println(TotalAppList);
	 }
}
