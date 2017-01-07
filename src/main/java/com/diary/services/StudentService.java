package com.diary.services;

import com.diary.dao.StudentDAO;
import com.diary.dto.GradeDTO;
import com.diary.model.Grade;
import com.diary.model.SchoolClass;
import com.diary.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by JaroLP on 2016-11-05.
 */

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    SchoolClassService schoolClassService;

    @Autowired
    GradeService gradeService;

    @Transactional
    public void create(Student student) {
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
    public void addStudentToClass(Long classID, Long studentID) {
        SchoolClass schoolClass = schoolClassService.getClassByID(classID);
        Student student = (Student) studentDAO.getById(Student.class, studentID);
        student.setSchoolClass(schoolClass);
        studentDAO.update(student);
    }

    @Transactional
    public void addGradeToStudent(Long studentID, Grade grade) {
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

    @Transactional
    public List<GradeDTO> prepareCardWithGrades(Long studentID) {
        HashMap<String, String> cardWithGrades = new HashMap<>();
        List<Grade> grades = gradeService.findGradesByStudent(studentID);
        grades.forEach(x -> cardWithGrades.put(x.getSubject().getName(), cardWithGrades.get(x.getSubject().getName()) == null ? cardWithGrades.get(x.getSubject().getName()) + x.getGradeValue() + "," : x.getGradeValue() + ","));

        Set<String> keys = cardWithGrades.keySet();
        List<GradeDTO> gradesAsLists = new ArrayList<>();
        keys.forEach(x -> gradesAsLists.add(new GradeDTO(x, cardWithGrades.get(x))));

        return gradesAsLists;
    }

}
