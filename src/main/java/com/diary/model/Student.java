package com.diary.model;

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
    @OneToMany(fetch = FetchType.EAGER)
    private List<Grade> grades;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Student> studentList;

}
