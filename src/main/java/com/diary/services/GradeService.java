package com.diary.services;

import com.diary.dao.GradeDAO;
import com.diary.dao.StudentDAO;
import com.diary.dao.SubjectDAO;
import com.diary.model.Grade;
import com.diary.model.SchoolClass;
import com.diary.model.Student;
import com.diary.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-06.
 */

@Service
public class GradeService {

    @Autowired
    private GradeDAO gradeDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public Grade addGrade(Grade grade){
        return gradeDAO.create(grade);
    }

    @Transactional
    public List<Grade> findAll(){
        return gradeDAO.findAll(Grade.class);
    }

    @Transactional
    public void addGradeToSubjectAndClass(Long gradeID, Long subjectID, Long studentID){
        Grade grade = gradeDAO.getById(Grade.class,gradeID);
        Subject subject = subjectDAO.getById(Subject.class,subjectID);
        Student student = (Student) studentDAO.getById(Student.class,studentID);


        grade.setStudent(student);
        grade.setSubject(subject);

        gradeDAO.update(grade);
    }
}
