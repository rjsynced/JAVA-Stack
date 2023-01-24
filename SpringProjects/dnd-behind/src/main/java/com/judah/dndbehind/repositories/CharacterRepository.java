package com.judah.dndbehind.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.judah.dndbehind.models.Character;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
	List<Character> findAll();
}
