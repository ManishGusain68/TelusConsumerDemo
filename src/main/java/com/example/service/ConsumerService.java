package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.controller.Student;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@RefreshScope
public class ConsumerService {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${url}")
	String url;
	
	@Autowired
	DiscoveryClient client;
	
	@CircuitBreaker(name="studentService" ,fallbackMethod = "getStudentfallback")
	public Student fetchStudentFromAPIWithId(int id) {
		//List<ServiceInstance> instances = client.getInstances("rest");
		Student student = restTemplate.getForObject(url+"/student/{id}", Student.class, id);
		return student;
	}
	public Student getStudentfallback(int id, Throwable throwable) {
		System.out.println("-------------in fallback method-------------"+ id);
		return new Student();
		//return "Fall bAck method response: error occured in producer api";
	}
	

//	public List<Student> fetchAllStudentFromAPI() {
//		List<Student> forObject = restTemplate.getForObject("http://rest/student", List.class);
//		return forObject;
//	}
//
//	public Student addStudentToStudentAPI(Student student) {
//		Student student2 = restTemplate.postForObject("http://rest/student", student, Student.class);
//		return student2;
//	}
//
//	public String deleteStudentFromStudentAPI(int id) {
//		try {
//		restTemplate.delete("http://rest/student/{id}", id);
//		}catch(HttpClientErrorException exception) {
//			throw new ConsumerDeleteException("Student is not availble in student api");
//		}
//		return "done";
//	}

}
