package com.miku.springdataJpa.demo.App.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.miku.springdataJpa.demo.appRepo.AppRepository;
import com.miku.springdataJpa.demo.appRepo.ServiceRepository;
import com.miku.springdataJpa.demo.appRepo.subApplicationRepository;
import com.miku.springdataJpa.demo.dao.ApplicationCodeDto;
import com.miku.springdataJpa.demo.dao.ApplicationCodeServiceCodeDto;
import com.miku.springdataJpa.demo.dao.ApplicationDto;
import com.miku.springdataJpa.demo.dao.ApplicationStatusDto;
import com.miku.springdataJpa.demo.dao.ServicesCodeDto;
import com.miku.springdataJpa.demo.dao.ServicesDto;
import com.miku.springdataJpa.demo.dao.ServicesStatusDto;
import com.miku.springdataJpa.demo.dao.SubApplicationDto;
import com.miku.springdataJpa.demo.dao.SubApplicationStatusDto;
import com.miku.springdataJpa.demo.entities.App.Applicaiton;
import com.miku.springdataJpa.demo.entities.App.Services;
import com.miku.springdataJpa.demo.entities.App.SubApplication;

@Service
public class AppService {

	@Autowired
	AppRepository repository;

	@Autowired
	subApplicationRepository subrepository;

	@Autowired
	ServiceRepository servicerepository;

	public List<Applicaiton> getApps() {
		return repository.findAll();
	}

	public Applicaiton getApp(int id) {
		return repository.findById(id).get();

	}

	public Applicaiton addApp(Applicaiton app) {
		return repository.save(app);

	}

	public Applicaiton updateApp(Applicaiton app) {

		return repository.save(app);
	}

	public void deleteAppById(int id) {
		repository.deleteById(id);
	}

	public List<ApplicationStatusDto> getApplicationListByStatus() {

		List<ApplicationStatusDto> applicationStatusDtoResponse = new ArrayList<>();

		List<Applicaiton> TotalList = repository.findAll();
		ApplicationStatusDto applicationStatusDtoY = new ApplicationStatusDto();
		ApplicationStatusDto applicationStatusDtoN = new ApplicationStatusDto();

		List<ApplicationDto> appListWithY = new ArrayList<>();
		List<ApplicationDto> appListWithN = new ArrayList<>();

		for (Applicaiton app : TotalList) {

			if (app.getStatus().equals("Y")) {

				ApplicationDto applicationdto = new ApplicationDto();

				applicationdto.setApplicationCode(app.getApplicationCode());
				applicationdto.setApplicationName(app.getApplicationName());
				appListWithY.add(applicationdto);

			}

			else if (app.getStatus().equals("N")) {
				ApplicationDto applicationdto = new ApplicationDto();

				applicationdto.setApplicationCode(app.getApplicationCode());
				applicationdto.setApplicationName(app.getApplicationName());
				appListWithN.add(applicationdto);
			}

		}

		applicationStatusDtoY.setStatus("Y");
		applicationStatusDtoY.setApplicationList(appListWithY);
		applicationStatusDtoResponse.add(applicationStatusDtoY);

		applicationStatusDtoN.setStatus("N");
		applicationStatusDtoN.setApplicationList(appListWithN);
		applicationStatusDtoResponse.add(applicationStatusDtoN);

		return applicationStatusDtoResponse;
	}

	public List<SubApplication> getSubApplications() {
		return subrepository.findAll();

	}

	public SubApplication AddSubApplication(SubApplication subApplication) {

		return subrepository.save(subApplication);
	}

	public SubApplication updateSubApplication(SubApplication subApplication) {

		return subrepository.save(subApplication);
	}

	public List<SubApplicationStatusDto> getSubApplicationStatus() {

		List<SubApplicationStatusDto> subApplicationStatusDtoResponse = new ArrayList<>();

		List<Applicaiton> TotalList = repository.findAll();

		for (Applicaiton app : TotalList) {

			SubApplicationStatusDto subapplicationStatusDtoY = new SubApplicationStatusDto();
			SubApplicationStatusDto subapplicationStatusDtoN = new SubApplicationStatusDto();

			List<SubApplicationDto> subappListWithYList = new ArrayList<>();
			List<SubApplicationDto> subappListWithNList = new ArrayList<>();

			if (app.getStatus().equals("Y")) {

				List<SubApplication> subApplicationListA = subrepository
						.findByApplicationCode(app.getApplicationCode());
				for (SubApplication subApplication : subApplicationListA) {
					
					SubApplicationDto subApplicationDto = new SubApplicationDto();
					subApplicationDto.setSubApplicationCode(subApplication.getApplicationCode());
					subApplicationDto.setSubApplicationName(subApplication.getSubApplicationName());
					subApplicationDto.setSubStatus(subApplication.getSubStatus());

					subappListWithYList.add(subApplicationDto);

				}

				subapplicationStatusDtoY.setStatus("Y");
				subapplicationStatusDtoY.setApplicationCode(app.getApplicationCode());
				subapplicationStatusDtoY.setSubApplicationList(subappListWithYList);
				subApplicationStatusDtoResponse.add(subapplicationStatusDtoY);

			} else if (app.getStatus().equals("N")) {

				List<SubApplication> subApplicationListB = subrepository
						.findByApplicationCode(app.getApplicationCode());
				
				for (SubApplication subApplication : subApplicationListB) {
				
					SubApplicationDto subApplicationDto = new SubApplicationDto();
					subApplicationDto.setSubApplicationCode(subApplication.getApplicationCode());
					subApplicationDto.setSubApplicationName(subApplication.getSubApplicationName());
					subApplicationDto.setSubStatus(subApplication.getSubStatus());
					subappListWithNList.add(subApplicationDto);

				}

				subapplicationStatusDtoN.setStatus("N");
				subapplicationStatusDtoN.setApplicationCode(app.getApplicationCode());
				subapplicationStatusDtoN.setSubApplicationList(subappListWithNList);
				subApplicationStatusDtoResponse.add(subapplicationStatusDtoN);
			}
		}

		return subApplicationStatusDtoResponse;

	}

	public List<Services> getServices() {
		return servicerepository.findAll();

	}

	public Services addServices(Services services) {

		return servicerepository.save(services);
	}

	public Services updateServices(Services services) {

		return servicerepository.save(services);
	}

	public List<ServicesStatusDto> getservicesStatusList() {

		List<ServicesStatusDto> ServicesDtoResponse = new ArrayList<>();

		List<Applicaiton> TotalAppList = repository.findAll();

		for (Applicaiton app : TotalAppList) {

			List<SubApplication> subApplicationList = subrepository.findByApplicationCode(app.getApplicationCode());

			for (SubApplication subApplication : subApplicationList) {

				ServicesStatusDto servicesStatusDto = new ServicesStatusDto();

				List<Services> servicesList = servicerepository
						.findBySubApplicationCode(subApplication.getSubApplicationCode());

				List<ServicesDto> servicesdtoList = new ArrayList<>();

				for (Services service : servicesList) {

					ServicesDto servicedto = new ServicesDto();
					servicedto.setServiceCode(service.getServiceCode());
					servicedto.setServiceName(service.getServiceName());
					servicesdtoList.add(servicedto);

				}
				servicesStatusDto.setApplicationCode(app.getApplicationCode());
				servicesStatusDto.setServiceList(servicesdtoList);
				ServicesDtoResponse.add(servicesStatusDto);
			}

		}
		return ServicesDtoResponse;
	}

	public ServicesStatusDto getServicesFrom(int applicationCode) {

		ServicesStatusDto servicesStatusDto = new ServicesStatusDto();

		List<SubApplication> subApplicationList = subrepository.findByApplicationCode(applicationCode);

		for (SubApplication subApplication : subApplicationList) {
 

			List<Services> servicesList = servicerepository
					.findBySubApplicationCode(subApplication.getSubApplicationCode());

			List<ServicesDto> servicesdtoList = new ArrayList<>();

			for (Services service : servicesList) {

				ServicesDto servicedto = new ServicesDto();
				servicedto.setServiceCode(service.getServiceCode());
				servicedto.setServiceName(service.getServiceName());
				servicesdtoList.add(servicedto);

			}
			servicesStatusDto.setApplicationCode(applicationCode);
			servicesStatusDto.setServiceList(servicesdtoList);
 
		}
		return servicesStatusDto;

	}
 
  

	public  ApplicationCodeServiceCodeDto getApplicationCodebyServiceCode(Integer serviceCode) {
 
		ApplicationCodeServiceCodeDto applicationCodeServiceCodeDto = new ApplicationCodeServiceCodeDto(); 
		
		applicationCodeServiceCodeDto.setApplicationCode(subrepository.findBySubApplicationCode(servicerepository.findByServiceCode(serviceCode).getSubApplicationCode()).getApplicationCode()); 
		applicationCodeServiceCodeDto.setApplicationName(repository.findByApplicationCode(subrepository.findBySubApplicationCode(servicerepository.findByServiceCode(serviceCode).getSubApplicationCode()).getApplicationCode()).getApplicationName());
		applicationCodeServiceCodeDto.setServiceCode(serviceCode);
 		
		return applicationCodeServiceCodeDto;
		}
	 
		  }