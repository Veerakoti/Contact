package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="USER_ACCOUNTFinal")
@Data
public class ContactEntity {
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(
			name="cid_seq_gen",
			sequenceName = "CONTACT_ID_SEQ",
			allocationSize = 1)
	@GeneratedValue(
			generator ="cid_seq_gen",
			strategy = GenerationType.SEQUENCE)
	private Integer regid;
	@Column(name="ACC_STATUS")
	private String accStatus;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="USER_EMAIL")
	private String email;
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "mm/ddyyyy")
	private Date dob;
	@Column(name="GENDER")
	private String gender;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE",updatable = false)
	private Date createDate;
	@Column(name = "UPDATED_DATE",insertable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	@Column(name = "USER_MOBILE")
	private long mobile;
	@Column(name = "COUNTRY_ID") 
	private Integer entity;
	@Column(name = "STATE_ID") 
	private Integer stateEntity;
	@Column(name = "CITY_ID") 
	private Integer cityEntity;
	@Column(name = "USER_PWD")
	private String pazzword;	

}
