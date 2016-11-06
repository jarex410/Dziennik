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
public class SchoolClass implements Serializable {

    private static final long serialVersionUID = 4565263L;

    @Id
    @NotNull
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Student> studentList;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Teacher> teacherList;

}
