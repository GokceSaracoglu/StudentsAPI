package com.saracoglu.students.controller;

import com.saracoglu.students.model.entitiy.StudentsToLectures;
import com.saracoglu.students.service.StudentsToLectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lectures")
public class StudentsToLectureController {

    @Autowired
    private StudentsToLectureService studentsToLectureService;

    @PostMapping
    public StudentsToLectures addLecture(@RequestParam Long studentId,@RequestParam Long lectureId){
        return studentsToLectureService.addLectureToStudent(studentId,lectureId);
    }

}
