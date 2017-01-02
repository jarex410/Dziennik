package com.diary.controller;

import com.diary.dto.StudentDTO;
import com.diary.model.DiaryUser;
import com.diary.model.Teacher;
import com.diary.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */
@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Teacher> getTeacherByID(@PathVariable("id") Long id) {
        Teacher teacher = teacherService.getTeacherByID(id);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.create(teacher);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<DiaryUser> findAll() {
        List<DiaryUser> teachers = teacherService.findAll();
        return teachers;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/grades")
    @ResponseBody
    public List<StudentDTO> getListOfStudentsWithGrades(@PathParam("classID") String classID) {
        return teacherService.getStudentWithGradesByClassAndSubject(Long.valueOf(classID));
    }

}
