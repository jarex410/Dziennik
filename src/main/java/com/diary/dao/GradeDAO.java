package com.diary.dao;

import com.diary.model.Grade;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */
@Repository
public class GradeDAO extends AbstractDAO<Grade> {

    @Autowired
    SessionFactory sessionFactory;

    public List<Grade> findGradesByStudentAndSubject(Long studenId, Long subjectId) {
        return (List<Grade>) this.sessionFactory.getCurrentSession()
                .createQuery("FROM Grade WHERE student_id = ? and subject_id = ?")
                .setParameter(0, studenId)
                .setParameter(1, subjectId)
                .list();
    }
}
