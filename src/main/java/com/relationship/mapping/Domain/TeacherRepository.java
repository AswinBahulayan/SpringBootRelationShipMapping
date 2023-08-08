package com.relationship.mapping.Domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationship.mapping.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
