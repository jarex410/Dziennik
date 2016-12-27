package com.diary.controller;

import com.diary.model.DiaryUser;
import com.diary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by JaroLP on 2016-12-27.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<DiaryUser> getByLogin(@PathParam("login") String login) {
        DiaryUser diaryUser = userService.findByLogin(login);
        return new ResponseEntity<DiaryUser>(diaryUser, HttpStatus.OK);
    }
}
