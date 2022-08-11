package com.lukejlackey.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lukejlackey.dojosninjas.models.Ninja;
import com.lukejlackey.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> findAll() {
		return ninjaRepo.findAll();
	}
	
	public Ninja findById(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		return null;
	}
	
	public List<Ninja> findAllByDojoId(Long id) {
		return ninjaRepo.findAllByDojoId(id);
	}
	
	public String createNinja(Ninja newNinja) {
	ninjaRepo.save(newNinja);
		return "Created new ninja: id#" + newNinja.getId();
	}

}
