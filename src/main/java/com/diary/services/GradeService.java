package com.diary.services;

import com.diary.dao.GradeDAO;
import com.diary.dao.StudentDAO;
import com.diary.dao.SubjectDAO;
import com.diary.model.Grade;
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

    @Autowired
    private SubjectService subjectService;

    @Transactional
    public Grade addGrade(Grade grade) {
        return gradeDAO.create(grade);
    }

    @Transactional
    public List<Grade> findAll() {
        return gradeDAO.findAll(Grade.class);
    }


}
