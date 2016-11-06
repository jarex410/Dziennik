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
public class User implements Serializable {

    private static final long serialVersionUID = 175273L;

    @Id
    @NotNull
    @GeneratedValue
    private long id;

    private String login;

    private String password;

    private String name;

    private String surname;

    private String address;
}
