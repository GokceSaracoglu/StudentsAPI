package com.saracoglu.students.repository;

import com.saracoglu.students.model.entitiy.Lectures;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lectures, Long>{
}
