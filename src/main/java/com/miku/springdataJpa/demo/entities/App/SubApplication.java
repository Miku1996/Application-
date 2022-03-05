package com.miku.springdataJpa.demo.entities.App;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name="Sub_Application")
public class SubApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer subId;
	
	@Column(name="subapplication_code")
	private int subApplicationCode;

	@Column(name="subapplication_name")
	private String subApplicationName;
	
	 
	@Column(name="application_code")
	private int applicationCode;
	
	@Column(name="sub_status")
	private String subStatus;
}
