package com.diary.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Entity
public class SchoolClass implements Serializable {

    private static final long serialVersionUID = 4565263L;

    @Id
    @SequenceGenerator(name = "ClassSeq", sequenceName = "CLASS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClassSeq")
    private Long id;

    @NotNull
    private String name;

    @OneToMany( fetch =  FetchType.EAGER)
    @JoinColumn(name="schoolClass_id")
    @Fetch(FetchMode.SELECT)
    private List<Student> studentList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

}
