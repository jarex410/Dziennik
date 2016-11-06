package com.diary.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

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

}
