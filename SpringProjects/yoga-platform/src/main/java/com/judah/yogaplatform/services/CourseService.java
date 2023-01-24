package com.judah.yogaplatform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.judah.yogaplatform.models.Course;
import com.judah.yogaplatform.repositories.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepo;
	public CourseService(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	public Course getOne(Long id) {
		Optional<Course> course = courseRepo.findById(id);
		return course.isPresent() ? course.get() : null;
	}
	
	public List<Course> getAll() {
		return(List<Course>) courseRepo.findAll();
	}
	
	public Course create(Course course) {
		return courseRepo.save(course);
	}
	
	public Course update(Course course) {
		return courseRepo.save(course);
	}
	
	public String deleteById(Long id) {
		courseRepo.deleteById(id);
		return "You have deleted an instance w/ an id of:" + id;
	}

}
