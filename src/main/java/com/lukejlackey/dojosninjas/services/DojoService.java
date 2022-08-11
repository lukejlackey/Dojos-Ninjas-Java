package com.lukejlackey.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lukejlackey.dojosninjas.models.Dojo;
import com.lukejlackey.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> findAll() {
		return dojoRepo.findAll();
	}
	
	public Dojo findById(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		return null;
	}
	
	public String createDojo(Dojo newDojo) {
		dojoRepo.save(newDojo);
		return "Created new dojo: id#" + newDojo.getId();
	}

}
