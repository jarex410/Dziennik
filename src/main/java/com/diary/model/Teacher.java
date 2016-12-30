package com.diary.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-02.
 */


public class Teacher extends DiaryUser {

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id")
    private List<Subject> subjectList;

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
