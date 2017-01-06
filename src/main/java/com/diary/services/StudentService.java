package com.diary.services;

import com.diary.dao.SchoolClassDAO;
import com.diary.dao.StudentDAO;
import com.diary.model.Grade;
import com.diary.model.SchoolClass;
import com.diary.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    SchoolClassDAO schoolClassDAO;

    @Transactional
    public void create(Student student){
        studentDAO.create(student);
    }

/*    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll(Student.class);
    }*/

    @Transactional
    public Student findStudentById(Long studentId) {
        return (Student) studentDAO.getById(Student.class, studentId);
    }


    @Transactional
    public void addStudentToClass(Long classID, Long studentID){
        SchoolClass schoolClass = schoolClassDAO.getById(SchoolClass.class,classID);
        Student student = (Student) studentDAO.getById(Student.class, studentID);
        student.setSchoolClass(schoolClass);
        studentDAO.update(student);
    }

    @Transactional
    public void addGradeToStudent(Long studentID, Grade grade){
        Student student = (Student) studentDAO.getById(Student.class, studentID);
        List<Grade> studentGrades = student.getGradeList();
        studentGrades.add(grade);
        student.setGradeList(studentGrades);
        studentDAO.update(student);
    }

    @Transactional
    public List<Student> findStudentsByClassID(Long clasID) {
        return studentDAO.findStudentsByClassID(clasID);
    }

}
