package com.diary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-02.
 */

@Entity
public class Subject implements Serializable {

    private static final long serialVersionUID = 2346741L;

    @Id
    @NotNull
    @SequenceGenerator(name = "SubjectSeq", sequenceName = "SUBJECT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SubjectSeq")
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<SchoolClass> schoolClasses;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    @JsonIgnore
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

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
