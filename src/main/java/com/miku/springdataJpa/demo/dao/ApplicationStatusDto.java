package com.miku.springdataJpa.demo.dao;

import java.util.List;

import lombok.Data;
@Data
public class ApplicationStatusDto {

	private String status;
	 List<ApplicationDto> applicationList;
}
