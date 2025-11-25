package example.spring.rest.data.jpa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import example.spring.rest.data.jpa.entity.Course;
import example.spring.rest.data.jpa.services.CourseService;

public class CourseController {
	@Autowired

	private CourseService serviceObject;

	

	@GetMapping("/courses")

	public Collection<Course> getAllCourses(){

		Collection<Course> allCourses = serviceObject.getAllCourse();

		return allCourses;

	}
	
	// ==> https://........./courses/C02
	@GetMapping("/courses/{crsId}")//crsId => Path Variable
	public Course getSingleCourse(@PathVariable("crsId") String courseId) {
		Course foundCourse = serviceObject.getOneCourse(courseId);
		return foundCourse;
	}
	
	@PostMapping("/courses")
	public void createNewCourse(@RequestBody Course courseObject) {
		//RequestBody =>Used to capture the data available in REQUEST object.
		serviceObject.createNewCourse(courseObject);
	}
	
	
}
