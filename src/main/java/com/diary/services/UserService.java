package com.diary.services;

import com.diary.dao.UserDAO;
import com.diary.model.DiaryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by JaroLP on 2016-12-27.
 */
@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public DiaryUser findByLogin(String login) {
        return userDAO.findByLogin(login);
    }
}
