package com.diary.controller;

import com.diary.model.Teacher;
import com.diary.model.User;
import com.diary.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Teacher> getTeacherByID(@PathVariable("id") Long id) {
        Teacher teacher = teacherService.getTeacherByID(id);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK) ;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.create(teacher);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll(){
        List<User> teachers = teacherService.findAll();
        return teachers;
    }

}
