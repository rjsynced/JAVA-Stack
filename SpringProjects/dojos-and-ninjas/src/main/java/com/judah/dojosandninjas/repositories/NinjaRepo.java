package com.judah.dojosandninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.judah.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long>{
	
}
