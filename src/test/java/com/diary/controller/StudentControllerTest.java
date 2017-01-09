package com.diary.controller;

import com.diary.model.SchoolClass;
import com.diary.model.Student;
import com.diary.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by JaroLP on 2017-01-09.
 */

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController = new StudentController();

    @Test
    public void testAddStudent() {
        Student student = new Student();
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setName("KLASA TESTOWA");
        student.setName("JANEK");
        student.setSurname("NOWAK");

        studentController.addStudent(student);
        verify((studentService), times(1)).create(student);

    }

}