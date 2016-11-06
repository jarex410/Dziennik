package com.diary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-02.
 */

@Data
@Entity
public class Student extends User{

    private static final long serialVersionUID = 789234L;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "studentList")
    private List<Subject> subjectList;

    @ManyToOne
    @JsonIgnore
    private SchoolClass schoolClass;
}
