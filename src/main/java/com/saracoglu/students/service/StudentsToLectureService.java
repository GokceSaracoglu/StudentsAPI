package com.saracoglu.students.service;

import com.saracoglu.students.model.entitiy.Lectures;
import com.saracoglu.students.model.entitiy.Students;
import com.saracoglu.students.model.entitiy.StudentsToLectures;
import com.saracoglu.students.repository.LectureRepository;
import com.saracoglu.students.repository.StudentRepository;
import com.saracoglu.students.repository.StudentsToLectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class StudentsToLectureService {

    @Autowired
    private StudentsToLectureRepository studentsToLectureRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LectureRepository lectureRepository;
    // Öğrenciye lectureId ile ders ekleyen metod

    @Transactional
    public StudentsToLectures addLectureToStudent(@RequestParam Long studentId, @RequestParam Long lectureId) {
        // Öğrenciyi bul
        Optional<Students> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Öğrenci bulunamadı.");
        }

        // Dersi bul
        Optional<Lectures> lectureOptional = lectureRepository.findById(lectureId);
        if (lectureOptional.isEmpty()) {
            throw new RuntimeException("Ders bulunamadı.");
        }

        Students student = studentOptional.get();
        Lectures lecture = lectureOptional.get();

        // Yeni bir StudentToLectures kaydı oluştur ve ilişkileri ekle
        StudentsToLectures studentToLectures = new StudentsToLectures();
        studentToLectures.setStudent(student);
        studentToLectures.setLecture(lecture);

        // Kaydet ve geri döndür
        return studentsToLectureRepository.save(studentToLectures);
    }
}
