package com.diary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-02.
 */


public class Student extends DiaryUser {

    private static final long serialVersionUID = 789234L;

    @ManyToOne
    @JsonIgnore
    private SchoolClass schoolClass;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="student_id")
    private List<Grade> gradeList;

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }
}
