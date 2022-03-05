package com.miku.springdataJpa.demo.entities.App;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString; 

@Entity
@Table(name="Application")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Applicaiton {
	@Id
	@Column(name="universal_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	 
	@Column(name="application_code")
	
	private Integer applicationCode;
	
	@Column(name="application_name")
	@NotBlank(message="Please add application name")
	private String applicationName;
	
	@Column(name="status")
	private String status;
	
	
	}
	
