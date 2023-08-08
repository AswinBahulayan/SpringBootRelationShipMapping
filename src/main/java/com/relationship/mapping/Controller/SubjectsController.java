package com.relationship.mapping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationship.mapping.Domain.StudentRepository;
import com.relationship.mapping.Domain.SubjectRepository;
import com.relationship.mapping.model.Student;
import com.relationship.mapping.model.Subjects;
import com.relationship.mapping.model.Teacher;
import com.relationship.mapping.pojo.EnrollSubjectToStudent;

@RestController
@RequestMapping("/Subjects")
public class SubjectsController {
	
	@Autowired
	public SubjectRepository subjectsRepository;
	
	@Autowired
	public StudentRepository studentRepository;
	
	@GetMapping("/{subjectId}")
	Optional<Subjects> getStudents(@PathVariable int subjectId){
		return subjectsRepository.findById(subjectId);
	}
	
	@GetMapping("/all")
	List<Subjects> getAllStudents(){
		return subjectsRepository.findAll();
	}
	
	@PostMapping("/createSubjects")	
	Subjects createStudent(@RequestBody Subjects subjects) {
		subjectsRepository.save(subjects);
		return subjects;
	}
	
	@PostMapping("/form/createSubjectForm")	
	Subjects createSubjectForm(@ModelAttribute Subjects subjects) {
		subjectsRepository.save(subjects);
		return subjects;
	}
	
	@PutMapping("/{subject_id}/enrolledby/{student_id}")
	Subjects enrollStudentsIntoSubjects(@PathVariable int subject_id, @PathVariable int student_id) {
		Subjects subjects = subjectsRepository.findById(subject_id).get();
		Student student = studentRepository.findById(student_id).get();
		subjects.enrollStudents(student);
		return subjectsRepository.save(subjects);
	}
	
	/*
	 * @PostMapping(value = "/enrollStudents",consumes =
	 * MediaType.APPLICATION_FORM_URLENCODED_VALUE) Subjects
	 * enrollStudentsIntoSubjects(@RequestBody EnrollSubjectToStudent
	 * enrollSubjectToStudent) { Subjects subjects =
	 * subjectsRepository.findById(Integer.parseInt(enrollSubjectToStudent.
	 * getSubject_Id())).get(); Student student =
	 * studentRepository.findById(Integer.parseInt(enrollSubjectToStudent.
	 * getStudent_Id())).get(); subjects.enrollStudents(student); return
	 * subjectsRepository.save(subjects); }
	 */
	
	@PostMapping(value = "/enrollStudents",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	Subjects enrollStudentsIntoSubjects(@ModelAttribute EnrollSubjectToStudent enrollSubjectToStudent) {
		Subjects subjects = subjectsRepository.findById(Integer.parseInt(enrollSubjectToStudent.getSubject_Id())).get();
		Student student = studentRepository.findById(Integer.parseInt(enrollSubjectToStudent.getStudent_Id())).get();
		subjects.enrollStudents(student);
		return subjectsRepository.save(subjects);
	}
}
