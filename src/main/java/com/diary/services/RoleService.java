package com.diary.services;

import com.diary.dao.RoleDAO;
import com.diary.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;


    @Transactional
    public Role getRoleById(long id) {
        Role role = roleDAO.getById(Role.class, id);
        return role;
    }

    @Transactional
    public List<Role> findAll() {
        List<Role> roleList = roleDAO.findAll(Role.class);
        return roleList;

    }

}
