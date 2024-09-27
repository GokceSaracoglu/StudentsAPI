package com.saracoglu.students.repository;

import com.saracoglu.students.model.entitiy.ExamScoresToStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamScoresRepository extends JpaRepository<ExamScoresToStudents, Long> {
}
