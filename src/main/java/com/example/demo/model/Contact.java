package com.example.demo.model;

import java.util.Date;

import lombok.Data;
@Data
public class Contact {

	private Integer regid;
	private String accStatus;
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	private String gender;
	private Date createDate;
	private Date updatedDate;
	private long mobile;
	private Integer entity;
	private Integer stateEntity;
	private Integer cityEntity;
	private String pazzword;
	
}
