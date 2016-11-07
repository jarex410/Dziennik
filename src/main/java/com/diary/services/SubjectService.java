package com.diary.services;

import com.diary.dao.GradeDAO;
import com.diary.dao.SchoolClassDAO;
import com.diary.dao.SubjectDAO;
import com.diary.dao.TeacherDAO;
import com.diary.model.*;
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

    @Autowired
    private SchoolClassDAO schoolClassDAO;

    @Autowired
    private GradeDAO gradeDAO;

    @Autowired
    private StudentService studentService;


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
        List<Subject> subjects = teacher.getSubjectList();
        subjects.add(subject);
        teacher.setSubjectList(subjects);
        teacherDAO.update(teacher);
    }

    @Transactional
    public void addGradeToSubjectAndStudent(Long gradeID, Long subjectID, Long studentID){
        Grade grade = gradeDAO.getById(Grade.class, gradeID);
        Subject subject = subjectDAO.getById(Subject.class,subjectID);
        List<Grade> grades = subject.getGrades();
        grades.add(grade);
        subject.setGrades(grades);
        studentService.addGradeToStudent(studentID,grade);

        subjectDAO.update(subject);
    }


    @Transactional
    public void addSubjectToClass(Long classID, Long subjectID) {
        SchoolClass schoolClass = schoolClassDAO.getById(SchoolClass.class, classID);
        Subject subject = subjectDAO.getById(Subject.class, subjectID);

        List<SchoolClass> schoolClasses = subject.getSchoolClasses();
        schoolClasses.add(schoolClass);
        subject.setSchoolClasses(schoolClasses);
        subjectDAO.update(subject);
    }

}
