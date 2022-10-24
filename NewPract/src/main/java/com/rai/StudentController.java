package com.rai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/mausam")
	public Student getStudent() {
		return new Student("Mausam", "Rai", "mausam@rai.com");
	}
	
	@GetMapping("/rai")
	public List<Student> getStudents(){
		List<Student> std = new ArrayList<>();
		std.add(new Student("Sumi", "Rai", "sumi@icloud.com"));
		std.add(new Student("Sumi", "Rai", "sumi@icloud.com"));
		std.add(new Student("Sumi", "Rai", "sumi@icloud.com"));
		std.add(new Student("Sumi", "Rai", "sumi@icloud.com"));
		std.add(new Student("Sumi", "Rai", "sumi@icloud.com"));
		std.add(new Student("Mausam", "Rai", "mau@icloud.com"));
		return std;
		
	}
	@GetMapping("/student/{firstName}/{lastName}/{email}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName, @PathVariable("email") String email) {
		return new Student(firstName, lastName, email);
	}
	
	@GetMapping("/student/query")
	public Student stdQueryParam(@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, @RequestParam(name = "email") String email) {
		return new Student(firstName, lastName, email);
	}
}
