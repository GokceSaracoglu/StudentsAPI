package com.saracoglu.students.model.entitiy;

import com.saracoglu.students.model.entitiy.Departments;
import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Students {

    @Id
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Departments department;

    public Students(){}
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments department) {
        this.department = department;
    }
}
