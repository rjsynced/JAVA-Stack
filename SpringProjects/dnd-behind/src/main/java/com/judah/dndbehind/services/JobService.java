package com.judah.dndbehind.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.judah.dndbehind.models.Job;
import com.judah.dndbehind.repositories.JobRepository;

@Service
public class JobService {

	private final JobRepository jobRepo;

	public JobService(JobRepository jobRepo) {
		this.jobRepo = jobRepo;
	}

	public Job getOne(Long id) {
		Optional<Job> job = jobRepo.findById(id);
		return job.isPresent() ? job.get() : null;
	}

	public List<Job> getAll() {
		return (List<Job>) jobRepo.findAll();
	}

	public Job create(Job job) {
		return jobRepo.save(job);
	}

	public Job update(Job job) {
		return jobRepo.save(job);
	}

	public String deleteById(Long id) {
		jobRepo.deleteById(id);
		return "You have deleted an instance w/ an id of:" + id;
	}

}
