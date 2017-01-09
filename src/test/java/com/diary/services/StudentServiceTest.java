package com.diary.services;

import com.diary.dao.StudentDAO;
import com.diary.model.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by JaroLP on 2017-01-09.
 */

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-context.xml"})
public class StudentServiceTest {

    @Autowired
    StudentDAO studentDAO;

    StudentService studentService = new StudentService();


    @Test
    @Ignore
    public void testCreateUser() throws Exception {
        Student student = new Student();
        student.setName("TEST NAME");
        student.setSurname("TEST SURNAME");
        student.setLogin("TEST LOGIN");

        studentService.create(student);

        assertEquals(student.getName(), studentDAO.findByLogin(student.getLogin()));
    }

}