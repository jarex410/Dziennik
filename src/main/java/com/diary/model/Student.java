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

    @ManyToOne
    @JsonIgnore
    private SchoolClass schoolClass;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="student_id")
    private List<Grade> gradeList;
}
