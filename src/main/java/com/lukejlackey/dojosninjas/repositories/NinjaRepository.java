package com.lukejlackey.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lukejlackey.dojosninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	List<Ninja> findAll();
	
	List<Ninja> findAllByDojoId(Long id);
	
}
