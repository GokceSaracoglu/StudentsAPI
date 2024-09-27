package com.saracoglu.students.model.entitiy;

import jakarta.persistence.*;

@Entity
@Table(name = "lectures")
public class Lectures {
    public Lectures(String lectureName) {
        this.lectureName = lectureName;
    }
    public Lectures() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long lectureId;

    @Column(name = "lecture_name", nullable = false)
    private String lectureName;

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }
}
