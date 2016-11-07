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
public class Grade  implements Serializable {

    private static final long serialVersionUID = 1232342L;

    @Id
    @SequenceGenerator(name = "GradeSeq", sequenceName = "GRADE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GradeSeq")
    private long id;

    private int gradeValue;

}
