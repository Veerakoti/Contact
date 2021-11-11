package com.example.demo.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.StateEntity;

public interface StateRepo extends JpaRepository<StateEntity, Serializable> {
	@Query(value = "SELECT s from StateEntity s WHERE s.countryId IN :cid")
	List<StateEntity> findAllByCountryId(@Param("cid") Integer cid);

}
