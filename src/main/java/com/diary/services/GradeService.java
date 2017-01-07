package com.diary.services;

import com.diary.dao.GradeDAO;
import com.diary.dao.SubjectDAO;
import com.diary.model.Grade;
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
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Transactional
    public Grade findGradeById(Long gradeId) {
        return gradeDAO.getById(Grade.class, gradeId);
    }


    @Transactional
    public Grade addGrade(Grade grade) {
        return gradeDAO.create(grade);
    }

    @Transactional
    public List<Grade> findAll() {
        return gradeDAO.findAll(Grade.class);
    }

    @Transactional
    public List<Grade> findGradesByStudentAndSubject(Long studentID, Long subjectID) {
        return gradeDAO.findGradesByStudentAndSubject(studentID, subjectID);
    }

    @Transactional
    public void removeGrade(Grade grade) {
        gradeDAO.delete(grade);
    }

    @Transactional
    public List<Grade> findGradesByStudent(Long studentID) {
        return gradeDAO.findGradesByStudentID(studentID);
    }
}
