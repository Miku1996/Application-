package com.miku.springdataJpa.demo.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.miku.springdataJpa.demo.App.service.AppService;
import com.miku.springdataJpa.demo.appRepo.AppRepository;
import com.miku.springdataJpa.demo.dao.ApplicationCodeDto;
import com.miku.springdataJpa.demo.dao.ApplicationCodeServiceCodeDto;
import com.miku.springdataJpa.demo.dao.ApplicationStatusDto;
import com.miku.springdataJpa.demo.dao.ServicesCodeDto;
import com.miku.springdataJpa.demo.dao.ServicesStatusDto;
import com.miku.springdataJpa.demo.dao.SubApplicationStatusDto;
import com.miku.springdataJpa.demo.entities.App.Applicaiton;
import com.miku.springdataJpa.demo.entities.App.Services;
import com.miku.springdataJpa.demo.entities.App.SubApplication;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/application")
public class AppRestController {

	@Autowired
	AppService service;

	@GetMapping
	public List<Applicaiton> getApps() {
		return service.getApps();

	}

	@PostMapping
	public Applicaiton addApp(@Valid @RequestBody Applicaiton app) {
		return service.addApp(app);
	}

	@PutMapping("/updateapps")
	public Applicaiton updateApp( @RequestBody Applicaiton app) {
		return service.updateApp(app);
	}

	@GetMapping("/{id}")
	public Applicaiton getAppById(@PathVariable("id") Integer id) {
		return service.getApp(id);
	}

	@DeleteMapping("/{id}")
	public void DeleteApp(@PathVariable("id") Integer id) {
		service.deleteAppById(id);

	}

	@GetMapping("/status")
	public List<ApplicationStatusDto> getApplicationListOnStatus() {
		return service.getApplicationListByStatus();

	}

	@GetMapping("/subApplication")
	public List<SubApplication> getAllSubApplication() {
		return service.getSubApplications();

	}

	@PostMapping("/subApplication")
	public SubApplication addSubApplication(@RequestBody SubApplication subapplication) {
		return service.AddSubApplication(subapplication);

	}

	@PutMapping("/updatesubapplication")
	public SubApplication updateSubApplication(@RequestBody SubApplication subapplication) {
		return service.updateSubApplication(subapplication);

	}

	@GetMapping("/substatus")
	public List<SubApplicationStatusDto> getSubApplicationStatusDto() {
		return service.getSubApplicationStatus();
	}

	@GetMapping("/service")
	public List<Services> getAllServices() {
		return service.getServices();
	}

	@PostMapping("/addservice")
	public Services addServices(@RequestBody Services services) {
		return service.addServices(services);
	}

	@PutMapping("/updateservice")
	public Services updateServices(@RequestBody Services services) {
		return service.updateServices(services);
	}

	@GetMapping("/serviceList")
	public List<ServicesStatusDto> getservicesStatusList() {
		return service.getservicesStatusList();
	}

	@GetMapping("/showServices")
	@ResponseBody
	public ServicesStatusDto getServicesFrom(@RequestParam(value = "applicationCode") int applicationCode) {
		return service.getServicesFrom(applicationCode);

	}

	@GetMapping("/name")
	public String getName(@RequestParam(name = "userName") String name) {
		return "My Name is " + name;

	}
 
	@GetMapping("/getAppCodebyServiceCode")
	public  ApplicationCodeServiceCodeDto  getApplicationCodebyServiceCode(
			@RequestParam(value = "serviceCode") int serviceCode) {
		return  service.getApplicationCodebyServiceCode(serviceCode);
	}
 @GetMapping("/getServices")
	public List<Services> getAllServicesList(){
		return service.getServices();
	
	}
}
