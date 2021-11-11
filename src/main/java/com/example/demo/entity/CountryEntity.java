package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="COUNTRY_MASTER")
public class CountryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	
	
	public CountryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CountryEntity(Integer countryId, String countryCode, String countryName) {
		super();
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}


	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public String toString() {
		return "CountryEntity [countryId=" + countryId + ", countryCode=" + countryCode + ", countryName=" + countryName
				+ "]";
	}
	
}
