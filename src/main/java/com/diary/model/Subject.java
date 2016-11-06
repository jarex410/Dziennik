package com.diary.model;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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


}
