package com.judah.dndbehind.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.judah.dndbehind.models.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
	List<Job> findAll();
}
