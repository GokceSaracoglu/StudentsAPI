package com.saracoglu.students.repository;

import com.saracoglu.students.model.entitiy.StudentsToLectures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsToLectureRepository extends JpaRepository<StudentsToLectures, Long> {
}
