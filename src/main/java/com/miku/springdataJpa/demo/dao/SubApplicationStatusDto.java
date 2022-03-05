package com.miku.springdataJpa.demo.dao;

import java.util.List;

import lombok.Data;
@Data
public class SubApplicationStatusDto {

	private String status;
	private int applicationCode;
	List<SubApplicationDto> subApplicationList;
}
