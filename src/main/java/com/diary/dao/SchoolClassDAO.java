package com.diary.dao;

import com.diary.model.SchoolClass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by JaroLP on 2016-11-02.
 */


@Repository
public class SchoolClassDAO extends AbstractDAO<SchoolClass> {

    @Autowired
    SessionFactory sessionFactory;

    private Session session;

}
