package com.saracoglu.students.service;

import com.saracoglu.students.model.entitiy.Departments;
import com.saracoglu.students.model.entitiy.Students;
import com.saracoglu.students.repository.DepartmentRepository;
import com.saracoglu.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Transactional
    public List<Students> getAllStudents(){
        return studentRepository.findAll();
    }
    @Transactional
    public Students getStudentById(Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    @Transactional
    public Students saveStudent(Students student) {
        // Log ekleme
        System.out.println("Received student: " + student);

        if (student.getDepartment() == null || student.getDepartment().getDepartmentId() == null) {
            throw new IllegalArgumentException("Departman bilgisi eksik veya geçersiz.");
        }

        // Departmanı veritabanında kontrol et
        Departments department = departmentRepository.findById(student.getDepartment().getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Departman bulunamadı"));

        student.setDepartment(department); // Eğer departman varsa, öğrenciye ata
        return studentRepository.save(student);
    }
    @Transactional
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}
