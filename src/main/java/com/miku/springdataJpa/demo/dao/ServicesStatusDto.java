package com.miku.springdataJpa.demo.dao;

import java.util.List;

import lombok.Data;

@Data
public class ServicesStatusDto {
	 
	private int applicationCode;
	List<ServicesDto> serviceList;

}
