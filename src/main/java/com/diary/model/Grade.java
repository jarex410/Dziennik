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
    @GeneratedValue
    private long id;

    private int gradeValue;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Subject subject;
}
