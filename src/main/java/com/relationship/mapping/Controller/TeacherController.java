package com.relationship.mapping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationship.mapping.Domain.TeacherRepository;
import com.relationship.mapping.model.Teacher;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	public TeacherRepository teacherRepository;
	
	@GetMapping("/{teacherId}")
	Optional<Teacher> getStudents(@PathVariable int teacherId){
		return teacherRepository.findById(teacherId);
	}
	
	@GetMapping("/all")
	List<Teacher> getAllStudents(){
		return teacherRepository.findAll();
	}
	
	@PostMapping("/createTeacher")
	Teacher createStudent(@RequestBody Teacher teacher) {
		teacherRepository.save(teacher);
		return teacher;
	}
}
