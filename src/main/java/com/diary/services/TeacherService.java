package com.diary.services;

import com.diary.dao.GradeDAO;
import com.diary.dao.SchoolClassDAO;
import com.diary.dao.StudentDAO;
import com.diary.dao.TeacherDAO;
import com.diary.dto.StudentDTO;
import com.diary.model.DiaryUser;
import com.diary.model.Student;
import com.diary.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */

@Service
public class TeacherService {

    @Autowired
    TeacherDAO teacherDAO;

    @Autowired
    SchoolClassDAO schoolClassDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    GradeDAO gradeDAO;

    @Transactional
    public void create(Teacher teacher) {
        teacherDAO.create(teacher);
    }

    @Transactional
    public Teacher getTeacherByID(Long id) {
        Teacher teacher = teacherDAO.getUser(Teacher.class, id);
        return teacher;
    }

    @Transactional
    public List<DiaryUser> findAll() {
        return teacherDAO.findAll(Teacher.class);
    }

    @Transactional
    public List<StudentDTO> getStudentWithGradesByClassAndSubject(final Long classID) {
        List<Student> students = studentDAO.findStudentsByClassID(Long.valueOf(classID));
        final List<StudentDTO> studentsWithGrades = new ArrayList<>();
        students.forEach(student -> studentsWithGrades.add(new StudentDTO(student.getName(), student.getSurname(), gradeDAO.findGradesByStudentAndSubject(student.getId(), classID))));
        return studentsWithGrades;
    }

}
