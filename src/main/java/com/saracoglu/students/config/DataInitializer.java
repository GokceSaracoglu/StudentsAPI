package com.saracoglu.students.config;

import com.saracoglu.students.model.entitiy.Lectures;
import com.saracoglu.students.repository.LectureRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.saracoglu.students.repository.DepartmentRepository; // Doğru yolu kontrol edin
import com.saracoglu.students.model.entitiy.Departments; // Doğru yolu kontrol edin

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (departmentRepository.count() == 0) {
            departmentRepository.save(new Departments( "Bilgisayar Mühendisliği"));
            departmentRepository.save(new Departments("Elektrik Mühendisliği"));
            departmentRepository.save(new Departments("Makine Mühendisliği"));
            departmentRepository.save(new Departments("İnşaat Mühendisliği"));
            departmentRepository.save(new Departments("Endüstri Mühendisliği"));
        }

        if (lectureRepository.count() == 0) {
            lectureRepository.save(new Lectures("Introduction to Programming"));
            lectureRepository.save(new Lectures("Calculus"));
            lectureRepository.save(new Lectures("Quantum Mechanics"));
            lectureRepository.save(new Lectures("Math"));
            lectureRepository.save(new Lectures("Physics"));
            lectureRepository.save(new Lectures("Chemistiry"));
        }
    }
}
