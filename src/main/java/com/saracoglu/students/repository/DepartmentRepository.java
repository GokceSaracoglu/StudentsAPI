package com.saracoglu.students.repository;

import com.saracoglu.students.model.entitiy.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, Long> {
}
