package com.diary.dto;

import java.util.List;

/**
 * Created by JaroLP on 2017-01-06.
 */
public class GradeDTO {

    List<String> values;

    Long studentID;

    Long subjectID;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public Long getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Long subjectID) {
        this.subjectID = subjectID;
    }
}
