package com.diary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @SequenceGenerator(name = "SubjectSeq", sequenceName = "SUBJECT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SubjectSeq")
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<SchoolClass> schoolClasses;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="subject_id")
    private List<Grade> grades;

}
