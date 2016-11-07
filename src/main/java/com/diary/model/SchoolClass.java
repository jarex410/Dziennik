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
    @SequenceGenerator(name = "ClassSeq", sequenceName = "CLASS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClassSeq")
    private long id;

    @NotNull
    private String name;

    @OneToMany( fetch =  FetchType.EAGER)
    @JoinColumn(name="schoolClass_id")
    private List<Student> studentList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Subject> subjectList;

}
