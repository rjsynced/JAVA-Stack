package com.judah.dndbehind.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.judah.dndbehind.models.Race;

@Repository
public interface RaceRepository extends CrudRepository<Race, Long> {
	List<Race> findAll();

}
