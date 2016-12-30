package com.diary.dao;

import com.diary.model.SchoolClass;
import com.diary.model.Subject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */
@Repository
public class SubjectDAO extends AbstractDAO<Subject> {

    @Autowired
    SessionFactory sessionFactory;

    public List<Subject> findSubjectByTeacherId(String teacherID) {
        return this.sessionFactory.getCurrentSession().createQuery("FROM Subject WHERE teacher_id = ?").setParameter(0, login).list().get(0));
    }
}
