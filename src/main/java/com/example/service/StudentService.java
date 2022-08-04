package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Student;
import com.example.repo.StudentRepo;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	StudentRepo studentrepo;
	
	public Student save(Student s) {
		Student save = studentrepo.save(s);
		return save;
	}
	
	public List<Student> getAllStud(){
		List<Student> getAll = studentrepo.findAll();
		return getAll;
	}
	
	public Optional<Student> getByID(@PathVariable int id) {
		Optional<Student> std = studentrepo.findById(id);
		return std;
	}
	
	public String deleteById(@PathVariable int id) {
		studentrepo.deleteById(id);
		return "Entry with id "+id+" is deleted from record";
	}
	
	
	
}
