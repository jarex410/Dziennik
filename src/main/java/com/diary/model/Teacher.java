package com.diary.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-02.
 */


@Entity
public class Teacher extends DiaryUser {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id")
    @Fetch(FetchMode.SELECT)
    private List<Subject> subjectList;

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
