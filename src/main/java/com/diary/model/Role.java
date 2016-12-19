package com.diary.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Role {

    @Id
    private Long id;
    private String name;
    private Short priority;

    @OneToMany( fetch =  FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<DiaryUser> users;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "priority")
    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public List<DiaryUser> getUsers() {
        return users;
    }

    public void setUsers(List<DiaryUser> users) {
        this.users = users;
    }
}
