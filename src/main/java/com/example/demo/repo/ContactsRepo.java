package com.example.demo.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.ContactEntity;

public interface ContactsRepo extends JpaRepository<ContactEntity, Serializable> {
	//@Query(value = "select USER_ID from c where USER_ID=:email")
	//public boolean checkEmail(String userEmail);
	public ContactEntity findUserByPazzwordAndEmail(String tempPwd,String email);
	//@Query(name = "from ContactEntity where email=:email")
	public ContactEntity findByEmail(String email);

}
