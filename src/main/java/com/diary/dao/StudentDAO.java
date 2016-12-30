package com.diary.dao;

import com.diary.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */

@Repository
public class StudentDAO extends UserDAO<Student> {

    @Autowired
    SessionFactory sessionFactory;

    public List<Student> findStudentsByClassID(Long clasID) {
        return (List<Student>) this.sessionFactory.getCurrentSession().createQuery("FROM Student WHERE schoolClass_id = ?").setParameter(0, clasID).list();
    }
}
