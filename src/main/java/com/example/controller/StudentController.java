package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@ApiOperation(value = "Add the brand with brand object",notes = "Provide a JSON Brand Object to store new brand")
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student s) {
		Student save = studentservice.save(s);
		return save;
	}
	
	
	@GetMapping("/all")
	public List<Student> getAll(){
		List<Student> all = studentservice.getAllStud();
		return all;
	}
	
	@GetMapping("get/{id}")
	public Optional<Student> getById(@PathVariable int id){
		Optional<Student> o = studentservice.getByID(id);
		return o;
	}
	
	@DeleteMapping("get/{id}")
	public String deleteById(@PathVariable int id) {
		studentservice.deleteById(id);
		return "Entry with id "+id+" is deleted from record";
	}
	

}
