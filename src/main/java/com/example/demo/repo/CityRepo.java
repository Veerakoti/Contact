package com.example.demo.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CityEntity;

public interface CityRepo extends JpaRepository<CityEntity, Serializable> {
	//@Query("select s from CityEntity s where stateId=:sid")
	@Query(value = "SELECT s from CityEntity s WHERE s.stateId IN :sid")
	List<com.example.demo.entity.CityEntity> findAllByStateId(@Param("sid") Integer sid);

}
