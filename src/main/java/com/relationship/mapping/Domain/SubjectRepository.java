package com.relationship.mapping.Domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationship.mapping.model.Subjects;

public interface SubjectRepository extends JpaRepository<Subjects, Integer> {

}
