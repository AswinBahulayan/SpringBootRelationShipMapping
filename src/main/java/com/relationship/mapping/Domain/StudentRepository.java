package com.relationship.mapping.Domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationship.mapping.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
