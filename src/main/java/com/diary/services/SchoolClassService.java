package com.diary.services;

import com.diary.dao.SchoolClassDAO;
import com.diary.model.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-03.
 */

@Service
public class SchoolClassService {

    @Autowired
    private SchoolClassDAO schoolClassDAO;

    @Transactional
    public void create(SchoolClass schoolClass) {
        schoolClassDAO.create(schoolClass);
    }

    @Transactional
    public SchoolClass getClassByID(Long id) {
        SchoolClass schoolClass = schoolClassDAO.getById(SchoolClass.class, id);
        return schoolClass;
    }

    @Transactional
    public List<SchoolClass> findAll() {
        return schoolClassDAO.findAll(SchoolClass.class);
    }

}
