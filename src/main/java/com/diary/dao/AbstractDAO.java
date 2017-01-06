package com.diary.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */
public abstract class AbstractDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    public AbstractDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    public T create(T t) {
        this.sessionFactory.getCurrentSession().save(t);
        return t;
    }

    public T update(T t) {
        this.sessionFactory.getCurrentSession().update(t);
        return t;
    }

    public void delete(T t) {
        this.sessionFactory.getCurrentSession().delete(t);
    }

    public T getById(Class clazz, Object t) {
        return (T) (this.sessionFactory.getCurrentSession().get(clazz, (Serializable) t));
    }

    public List<T> findAll(Class clazz) {
        List<T> list = (List<T>) sessionFactory.getCurrentSession().createQuery("FROM " + clazz.getName()).list();
        return list;
    }

}
