package com.miku.springdataJpa.demo.entities.App;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Service_Table")
public class Services {

	@Id
	@Column(name="service_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer serviceId;
	
	@Column(name="service_code")
	private int serviceCode;
	
	@Column(name="service_name")
	private String serviceName;
	
	@Column(name="subapplication_code")
	private int subApplicationCode;
	
	
}
