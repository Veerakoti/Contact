package com.example.demo.model;

public class Country {
	private Integer countryId;
	private String countryCode;
	private String countryName;
	

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Country(Integer countryId, String countryCode, String countryName) {
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
