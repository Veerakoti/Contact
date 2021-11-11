package com.example.demo.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constants.AppConstants;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.ContactEntity;
import com.example.demo.entity.CountryEntity;
import com.example.demo.entity.StateEntity;
import com.example.demo.exception.ContactException;
import com.example.demo.model.Contact;
import com.example.demo.repo.CityRepo;
import com.example.demo.repo.ContactsRepo;
import com.example.demo.repo.CountryRepo;
import com.example.demo.repo.StateRepo;
import com.example.demo.utils.EmailUtils;
import com.example.demo.utils.PwdUtils;
@Service
public class ContactServiceimpl implements ContactService {
	@Autowired
	private ContactsRepo repo;
	@Autowired
	private CountryRepo crepo;
	@Autowired
	private StateRepo srepo;
	@Autowired
	private CityRepo cirepo;
	@Autowired
	private PwdUtils pwdUtils;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean saveContact(Contact contact) {

		boolean isSaved=false;
		try {
			ContactEntity entity=new ContactEntity();
			BeanUtils.copyProperties(contact, entity);
			System.out.println(contact);
			ContactEntity save = repo.save(entity);
			System.out.println("saving details "+save);
			if(save.getRegid()!=null) {
				isSaved=true;
				System.out.println(save+"in if condition");
			}
		} catch (Exception e) {
			throw new ContactException("contact saved failed");
		}

		return isSaved;
	}
	@Override 
	public Map<Integer, String> getAllCountries() { 
		Map<Integer,String> map=new LinkedHashMap<Integer, String>(); 
		List<CountryEntity> countryEntities=crepo.findAll(); 
		//System.out.println(countryEntities); 
		for(CountryEntity countryEntity : countryEntities) {
			map.put(countryEntity.getCountryId(), countryEntity.getCountryName()); 
		}
		//System.out.println(map);

		return map;
	}

	@Override
	public boolean getAccountReg(Contact contact) {

		contact.setPazzword(PwdUtils.generateTempPwd(AppConstants.TEM_PWD_LENGTH));
		contact.setAccStatus(AppConstants.LOCKED_STR);
		System.out.println(contact);
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactEntity save = repo.save(entity);
		if(save.getRegid()!=null) {
			return emailUtils.sendUserAccUnlockEmail(contact);
		}
		return false;
	}
	@Override
	public Map<Integer, String> getStatesByCountryId(Integer cid) {
		Map<Integer, String> map=new LinkedHashMap<Integer, String>();
		List<StateEntity> states=srepo.findAllByCountryId(cid);
		//	System.out.println(states);
		for (StateEntity stateEntity : states) {
			map.put(stateEntity.getStateId(), stateEntity.getStateName());
			//	System.out.println(map);

		}
		System.out.println(map);
		return map;
	}
	@Override
	public Map<Integer, String> getCitiesByStateId(Integer sid) {
		Map<Integer, String> map=new LinkedHashMap<Integer, String>();
		List<CityEntity> cities=cirepo.findAllByStateId(sid);
		//	System.out.println(cities);
		for (CityEntity cityEntity : cities) {
			map.put(cityEntity.getCityId(), cityEntity.getCityName());

		}
		return map;
	}
	@Override
	public Contact getContactByTempPwd(String tempPwd,String email) {
		ContactEntity findUserByPazzword = repo.findUserByPazzwordAndEmail(tempPwd,email);
		Contact contact=null;
		if(findUserByPazzword!=null) {
			contact=new Contact();
			BeanUtils.copyProperties(findUserByPazzword, contact);	
		}
		return contact;
	}
	@Override
	public boolean updateUserAcc(Contact contact) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactEntity save = repo.save(entity);
		return save!=null;
	}
	@Override
	public String findByEmail(String email) {
		ContactEntity entity = repo.findByEmail(email);
		if(null!=entity) {
			return "Duplicate";
		}
		return "Unique";
	}




}
