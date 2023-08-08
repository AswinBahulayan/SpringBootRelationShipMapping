package com.relationship.mapping.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	private String name;

	@ManyToMany
	@JoinTable(name = "studentsEnrolled", joinColumns = @JoinColumn(name = "Subject_id"), inverseJoinColumns = @JoinColumn(name = "student_Id"))
	private Set<Student> studentsEnrolled = new HashSet<Student>();

	public Set<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(Set<Student> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public Subjects() {

	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void enrollStudents(Student student) {
		studentsEnrolled.add(student);
	}

}
