package com.example.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Course;
import com.example.student.model.Student;
import com.example.student.repository.CourseRepository;
import com.example.student.repository.StudentRepository;

@RestController
public class MainController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
   
	@GetMapping("/")
	public String hello() {
		return "hello Eshad";
	}
	
	@GetMapping("/student/all")
	public List<Student> getStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable int id){
		return studentRepo.findById(id);
	}
	
	@PostMapping("/student/add")
	public Student addStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/course/all")
	public List<Course> getcourses(){
		return courseRepo.findAll();
	}
     
	@GetMapping("/course/{id}")
	public Optional<Course> getCourse(@PathVariable int id){
		return courseRepo.findById(id);
	}
	
	@PostMapping("/course/add")
	public Course addCourse(@RequestBody Course course) {
		return courseRepo.save(course);
	}
	
	@PostMapping("/student/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		if(studentRepo.existsById(id)){
			studentRepo.deleteById(id);
			return "Successfully deleted from the database";
		}	
		else {
			return "failed to deleted from the database";
		}
	}
}
