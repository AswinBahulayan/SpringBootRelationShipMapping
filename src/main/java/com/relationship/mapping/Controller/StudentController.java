package com.relationship.mapping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationship.mapping.Domain.StudentRepository;
import com.relationship.mapping.model.Student;
import com.relationship.mapping.model.Subjects;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	public StudentRepository studentRepository;
	
	@GetMapping("/{studentId}")
	Optional<Student> getStudents(@PathVariable int studentId){
		return studentRepository.findById(studentId);
	}
	
	@GetMapping("/all")
	List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@PostMapping("/createStudent")
	Student createStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	
	@PostMapping("/form/createStudentForm")	
	Student createStudentsForm(@ModelAttribute Student student) {
		studentRepository.save(student);
		return student;
	}
}
