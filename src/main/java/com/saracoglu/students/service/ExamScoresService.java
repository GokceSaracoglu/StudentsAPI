package com.saracoglu.students.service;

import com.saracoglu.students.model.entitiy.ExamScoresToStudents;
import com.saracoglu.students.model.entitiy.StudentsToLectures;
import com.saracoglu.students.repository.ExamScoresRepository;
import com.saracoglu.students.repository.StudentsToLecturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class ExamScoresService {
    @Autowired
    private ExamScoresRepository examScoresToStudentRepository;

    @Autowired
    private StudentsToLecturesRepository studentsToLectureRepository;
    @Transactional
    public ExamScoresToStudents addExamScore(@RequestParam Long studentToLectureId, @RequestParam Integer examScore) {
        // StudentsToLectures kaydını bul
        Optional<StudentsToLectures> studentToLecturesOptional = studentsToLectureRepository.findById(studentToLectureId);

        if (studentToLecturesOptional.isEmpty()) {
            throw new RuntimeException("Öğrenci-Ders ilişkisi bulunamadı.");
        }

        // Öğrenci-Ders ilişkisini getir
        StudentsToLectures studentToLectures = studentToLecturesOptional.get();

        // Yeni ExamScoresToStudents kaydı oluştur
        ExamScoresToStudents examScoresToStudents = new ExamScoresToStudents();
        examScoresToStudents.setStudentsToLecture(studentToLectures);
        examScoresToStudents.setExamScore(examScore);

        // Kaydı veritabanına kaydet
        return examScoresToStudentRepository.save(examScoresToStudents);
    }
}
