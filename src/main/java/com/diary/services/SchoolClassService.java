package com.diary.services;

import com.diary.dao.SchoolClassDAO;
import com.diary.dao.StudentDAO;
import com.diary.dao.SubjectDAO;
import com.diary.dao.TeacherDAO;
import com.diary.model.SchoolClass;
import com.diary.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-03.
 */

@Service
public class SchoolClassService {

    @Autowired
    private SchoolClassDAO schoolClassDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private SubjectDAO subjectDAO;


    @Transactional
    public void create(SchoolClass schoolClass) {
        schoolClassDAO.create(schoolClass);
    }

    @Transactional
    public SchoolClass getClassByID(Long id) {
        SchoolClass schoolClass = schoolClassDAO.getById(SchoolClass.class, id);
        return schoolClass;
    }

    @Transactional
    public List<SchoolClass> findAll() {
        return schoolClassDAO.findAll(SchoolClass.class);
    }

    @Transactional
    public void addSubjectToClass(Long classID, Long subjectID){
        Subject subject = subjectDAO.getById(Subject.class,subjectID);
        SchoolClass schoolClass = schoolClassDAO.getById(SchoolClass.class,classID);

        List<SchoolClass> schoolClasses = subject.getSchoolClasses();
        schoolClasses.add(schoolClass);

        schoolClassDAO.update(schoolClass);
    }
/*
    @Transactional
    public void addTeacherToClass(Long teacherID, Long schoolClassID) {
        SchoolClass schoolClass = schoolClassDAO.getById(SchoolClass.class, schoolClassID);
        Teacher teacher = teacherDAO.getUser(Teacher.class, teacherID);

        List<Teacher> teachers = schoolClass.getTeacherList();
        teachers.add(teacher);
        schoolClass.setTeacherList(teachers);
        schoolClassDAO.update(schoolClass);
    }*/
}
