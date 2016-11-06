package com.diary.dao;

import com.diary.model.User;
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
public abstract class UserDAO<T> extends AbstractDAO<User> {

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

}
