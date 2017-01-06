package com.diary.dto;

import com.diary.model.Grade;

import java.util.List;

/**
 * Created by JaroLP on 2017-01-02.
 */
public class StudentDTO {

    private long id;

    private String name;

    private String surname;

    private List<Grade> grades;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public StudentDTO(Long id, String name, String surname, List<Grade> grades) {
        this.name = name;
        this.surname = surname;
        this.grades = grades;
        this.id = id;
    }
}
