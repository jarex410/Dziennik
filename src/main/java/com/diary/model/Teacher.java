package com.diary.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-02.
 */


@Data
@Entity
public class Teacher extends User{

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
    private List<Subject> subjectList;


}
