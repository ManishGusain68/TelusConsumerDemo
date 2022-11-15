package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ConsumerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ConsumerController {
	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping(value= "/fetchStudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student fetchStudent(@PathVariable int id) {
		return consumerService.fetchStudentFromAPIWithId(id);
	}
	
	

//	@GetMapping("/fetchAllStudent")
//	public List<Student> fetchStudent() {
//		return consumerService.fetchAllStudentFromAPI();
//	}
//	
//	@PostMapping("/addStudent")
//	public Student addDtudent(@RequestBody Student student) {
//		return consumerService.addStudentToStudentAPI(student);
//	}
//	
//	@DeleteMapping("/deleteStudent/{id}")
//	public String deleteStudent(@PathVariable int id) {
//		return consumerService.deleteStudentFromStudentAPI(id);
//	}
	
	
}
