package com.diary.services;

import com.diary.dao.SchoolClassDAO;
import com.diary.dao.TeacherDAO;
import com.diary.model.SchoolClass;
import com.diary.model.Teacher;
import com.diary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<User> findAll(){
        return teacherDAO.findAll(Teacher.class);
    }

}
