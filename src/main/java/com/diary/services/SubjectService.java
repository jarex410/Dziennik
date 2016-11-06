package com.diary.services;

import com.diary.dao.SubjectDAO;
import com.diary.dao.TeacherDAO;
import com.diary.model.Subject;
import com.diary.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-06.
 */

@Service
public class SubjectService {

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private TeacherDAO teacherDAO;


    @Transactional
    public Subject addNewSubject(Subject subject){
        return subjectDAO.create(subject);
    }

    @Transactional
    public List<Subject> findAll(){
        return subjectDAO.findAll(Subject.class);
    }

    @Transactional
    public void addSubjectToTeacher(Long subjectID, Long teacherID){
        Subject subject = subjectDAO.getById(Subject.class, subjectID);
        Teacher teacher = teacherDAO.getUser(Teacher.class,teacherID);

        subject.setTeacher(teacher);

        subjectDAO.update(subject);
    }

}
