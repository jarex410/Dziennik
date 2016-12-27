package com.diary.dao;

import com.diary.model.DiaryUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by JaroLP on 2016-11-05.
 */
@Repository
public class UserDAO<T> extends AbstractDAO<DiaryUser> {

    @Autowired
    SessionFactory sessionFactory;

    private Class<T> type;

    public UserDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    public T getUser(Class clazz, Object t) {
        return (T) (this.sessionFactory.getCurrentSession().get(clazz, (Serializable) t));
    }

    public DiaryUser findByLogin(String login) {
        return (DiaryUser) sessionFactory.getCurrentSession().createQuery("FROM DiaryUser WHERE login = ?").setParameter(0, login);
    }

}
