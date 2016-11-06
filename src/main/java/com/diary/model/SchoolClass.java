package com.diary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Data
@Entity
public class SchoolClass implements Serializable {

    private static final long serialVersionUID = 4565263L;

    @Id
    @NotNull
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @OneToMany( fetch =  FetchType.EAGER, mappedBy = "schoolClass")
    private List<Student> studentList;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "schoolClasses")
    @JsonIgnore
    private List<Subject> subjectList;

}
