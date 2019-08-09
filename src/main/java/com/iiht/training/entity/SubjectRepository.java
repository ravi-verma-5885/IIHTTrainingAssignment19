package com.iiht.training.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	public final static String subject_from_fitle ="Select s from Subject s Where s.subjectTitle = :subjectTitle";

	@Query(subject_from_fitle)
	public Subject findSubjectByTitle(@Param("subjectTitle") String subjectTitle);

}
