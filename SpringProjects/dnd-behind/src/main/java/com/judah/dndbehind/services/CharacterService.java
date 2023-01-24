package com.judah.dndbehind.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.judah.dndbehind.models.Character;
import com.judah.dndbehind.repositories.CharacterRepository;

@Service
public class CharacterService {

	private final CharacterRepository characterRepo;

	public CharacterService(CharacterRepository characterRepo) {
		this.characterRepo = characterRepo;
	}

	public Character getOne(Long id) {
		Optional<Character> character = characterRepo.findById(id);
		return character.isPresent() ? character.get() : null;
	}

	public List<Character> getAll() {
		return (List<Character>) characterRepo.findAll();
	}

	public Character create(Character course) {
		return characterRepo.save(course);
	}

	public Character update(Character course) {
		return characterRepo.save(course);
	}

	public String deleteById(Long id) {
		characterRepo.deleteById(id);
		return "You have deleted an instance w/ an id of:" + id;
	}

}