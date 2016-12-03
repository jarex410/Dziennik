package com.diary.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JaroLP on 2016-11-02.
 */


@Entity
public class Grade  implements Serializable {

    private static final long serialVersionUID = 1232342L;

    @Id
    @SequenceGenerator(name = "GradeSeq", sequenceName = "GRADE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GradeSeq")
    private long id;

    private int gradeValue;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(int gradeValue) {
        this.gradeValue = gradeValue;
    }
}
