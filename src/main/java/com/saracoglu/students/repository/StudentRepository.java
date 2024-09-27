package com.saracoglu.students.repository;

import com.saracoglu.students.model.entitiy.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {

}
