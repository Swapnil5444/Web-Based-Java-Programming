package example.spring.rest.data.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import example.spring.rest.data.jpa.entity.Course;

//No need of @REpository because JpaRepository is already a Managed Component
//Add CourseRepository is extended from it so it also becomes a Managed Component
public interface CourseRepository extends JpaRepository<Course,String> {
	//Additional methods if any.
	//Nothing to be added if only regular CRUD operations are to be performed.
}
