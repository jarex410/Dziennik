package com.diary.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-02.
 */

@Data
@Entity
public class Subject implements Serializable {

    private static final long serialVersionUID = 2346741L;

    @Id
    @NotNull
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subject")
    private List<Grade> grades;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> studentList;

    @ManyToOne
    private Teacher teacher;


}
