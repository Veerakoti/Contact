package com.example.demo.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CountryEntity;
@Repository
public interface CountryRepo extends JpaRepository<CountryEntity, Serializable>{
	@Query("select countryName from CountryEntity")
	public List<String> findAllContrys();

}
