package com.saracoglu.students.model.entitiy;

import jakarta.persistence.*;

@Entity
public class StudentsToLectures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "students_to_lecture_id")
    private Long studentsToLectureId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lectures lecture;

    public StudentsToLectures(){}
    public Long getStudentsToLectureId() {
        return studentsToLectureId;
    }

    public void setStudentsToLectureId(Long studentsToLectureId) {
        this.studentsToLectureId = studentsToLectureId;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Lectures getLecture() {
        return lecture;
    }

    public void setLecture(Lectures lecture) {
        this.lecture = lecture;
    }
}
