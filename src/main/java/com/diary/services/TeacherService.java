package com.diary.services;

import com.diary.dao.SchoolClassDAO;
import com.diary.dao.TeacherDAO;
import com.diary.dto.GradeDTO;
import com.diary.dto.StudentDTO;
import com.diary.model.*;
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
    StudentService studentService;

    @Autowired
    GradeService gradeService;

    @Autowired
    SubjectService subjectService;

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
    public List<StudentDTO> getStudentWithGradesByClassAndSubject(Long classID, Long subjectID) {
        List<Student> students = studentService.findStudentsByClassID(Long.valueOf(classID));
        final List<StudentDTO> studentsWithGrades = new ArrayList<>();
        students.forEach(student -> studentsWithGrades.add(new StudentDTO(student.getId(), student.getName(), student.getSurname(), gradeService.findGradesByStudentAndSubject(student.getId(), subjectID))));
        return studentsWithGrades;
    }

    @Transactional
    public void addGradeToStudent(GradeDTO gradeDTO) {
        List<String> listOfGradesValues = gradeDTO.getValues();
        Student student = studentService.findStudentById(gradeDTO.getStudentID());
        Subject subject = subjectService.getById(gradeDTO.getSubjectID());

        List<Grade> currentGrades = gradeService.findGradesByStudentAndSubject(gradeDTO.getStudentID(), gradeDTO.getSubjectID());

        currentGrades.forEach(x -> gradeService.removeGrade(x));

        listOfGradesValues.forEach(x -> gradeService.addGrade(new Grade(Integer.parseInt(x), student, subject)));
    }
}
