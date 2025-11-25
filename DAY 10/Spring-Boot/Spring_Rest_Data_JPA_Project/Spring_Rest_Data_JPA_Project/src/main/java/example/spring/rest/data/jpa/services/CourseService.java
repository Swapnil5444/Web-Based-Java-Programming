package example.spring.rest.data.jpa.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.spring.rest.data.jpa.entity.Course;
import example.spring.rest.data.jpa.repo.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repoObj;
	
	public Collection<Course> getAllCourse(){
		Collection<Course> allCourses = repoObj.findAll();
		return allCourses;
	}
	
	public Course getOneCourse(String courseId) {
		Optional<Course> opRef = repoObj.findById(courseId);
		Course foundCourse = null;
		if(opRef.isPresent()) 
			foundCourse = opRef.get();
		return foundCourse;
	}

	public void createNewCourse(Course courseObj) {
		repoObj.save(courseObj);
	}
	
}
