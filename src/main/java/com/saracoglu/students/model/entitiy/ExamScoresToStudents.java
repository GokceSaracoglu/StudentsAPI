package com.saracoglu.students.model.entitiy;

import jakarta.persistence.*;

@Entity
public class ExamScoresToStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_scores_to_students_id")
    private Long examScoresToStudentId;

    @ManyToOne
    @JoinColumn (name = "students_to_lectures_id", nullable = false)
    private StudentsToLectures studentsToLectures;

    @Column(name = "exam_score", nullable = false)
    private Integer examScore;

    public ExamScoresToStudents(){}
    public Long getExamScoresToStudentId() {
        return examScoresToStudentId;
    }

    public void setExamScoresToStudentId(Long examScoresToStudentId) {
        this.examScoresToStudentId = examScoresToStudentId;
    }

    public StudentsToLectures getStudentsToLecture() {
        return studentsToLectures;
    }

    public void setStudentsToLecture(StudentsToLectures studentsToLectures) {
        this.studentsToLectures = studentsToLectures;
    }

    public Integer getExamScore() {
        return examScore;
    }

    public void setExamScore(Integer examScore) {
        this.examScore = examScore;
    }
}
