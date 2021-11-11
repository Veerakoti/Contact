package com.example.demo.service;

import java.util.Map;

import com.example.demo.model.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	public Map<Integer,String> getAllCountries();
	public Map<Integer,String> getStatesByCountryId(Integer cid);
	public Map<Integer,String> getCitiesByStateId(Integer sid);
	public boolean getAccountReg(Contact contact);
	
	public Contact getContactByTempPwd(String tempPwd,String email);
	public boolean updateUserAcc(Contact contact);
	public String findByEmail(String email);

}
