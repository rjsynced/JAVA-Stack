package com.judah.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.judah.dojosandninjas.models.Dojo;
import com.judah.dojosandninjas.models.Ninja;
import com.judah.dojosandninjas.repositories.DojoRepo;
import com.judah.dojosandninjas.repositories.NinjaRepo;

@Service
public class DojoNinjaServ {
	
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	
	public DojoNinjaServ(DojoRepo dojoRepo, NinjaRepo ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo oneDojo(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		else {
			return null;
		}
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}

}
