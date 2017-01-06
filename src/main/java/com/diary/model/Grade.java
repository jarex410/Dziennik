package com.diary.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JaroLP on 2016-11-02.
 */


@Entity
public class Grade  implements Serializable {

    private static final long serialVersionUID = 1232342L;

    @Id
    @SequenceGenerator(name = "GradeSeq", sequenceName = "GRADE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GradeSeq")
    private Long id;

    private Integer gradeValue;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subjec_id")
    private Subject subject;

    public Grade() {
    }

    public Grade(Integer gradeValue, Student student, Subject subject) {
        this.gradeValue = gradeValue;
        this.student = student;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
