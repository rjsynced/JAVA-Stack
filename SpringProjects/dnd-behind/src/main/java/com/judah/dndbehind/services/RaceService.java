package com.judah.dndbehind.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.judah.dndbehind.models.Race;
import com.judah.dndbehind.repositories.RaceRepository;

@Service
public class RaceService {

	private final RaceRepository raceRepo;

	public RaceService(RaceRepository raceRepo) {
		this.raceRepo = raceRepo;
	}

	public Race getOne(Long id) {
		Optional<Race> race = raceRepo.findById(id);
		return race.isPresent() ? race.get() : null;
	}

	public List<Race> getAll() {
		return (List<Race>) raceRepo.findAll();
	}

	public Race create(Race race) {
		return raceRepo.save(race);
	}

	public Race update(Race race) {
		return raceRepo.save(race);
	}

	public String deleteById(Long id) {
		raceRepo.deleteById(id);
		return "You have deleted an instance w/ an id of:" + id;
	}

}