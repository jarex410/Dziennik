package com.diary.services;

import com.diary.dao.UserDAO;
import com.diary.model.DiaryUser;
import com.diary.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class LoginService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) {
        DiaryUser user = userDAO.findByLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());

        return buildUserForAuthentication(user, authorities);

    }

    // Converts User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(DiaryUser user, List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Role userRoles) {

        Set<SimpleGrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        setAuths.add(new SimpleGrantedAuthority(userRoles.getName()));


        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
}
