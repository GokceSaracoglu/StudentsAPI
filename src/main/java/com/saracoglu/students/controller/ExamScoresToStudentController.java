package com.saracoglu.students.controller;


import com.saracoglu.students.model.entitiy.ExamScoresToStudents;
import com.saracoglu.students.service.ExamScoresToStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exams")
public class ExamScoresToStudentController {
    @Autowired
    private ExamScoresToStudentService examScoresToStudentService;

    @PostMapping
    public ExamScoresToStudents addExamScore(@RequestParam Long studentToLectureId, @RequestParam Integer score){
        return examScoresToStudentService.addExamScore(studentToLectureId, score);
    }
}
