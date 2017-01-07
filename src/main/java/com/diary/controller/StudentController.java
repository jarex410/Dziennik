package com.diary.controller;

import com.diary.model.Student;
import com.diary.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-05.
 */

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

/*    @RequestMapping(method = RequestMethod.GET)
    public List<DiaryUser> findAll() {
        return studentService.findAll();
    }*/

    @RequestMapping(method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentService.create(student);
    }

    @RequestMapping(path = "/{studentID}/class/{classID}", method = RequestMethod.PUT)
    public void addStudentToClass(@PathVariable("classID") String classID, @PathVariable("studentID") String studentID){
        studentService.addStudentToClass(Long.valueOf(classID), Long.valueOf(studentID));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Student> findStudentByClass(@PathParam("classID") String classID) {
        return studentService.findStudentsByClassID(Long.valueOf(classID));
    }

    @RequestMapping(path = "/card/{studentID}", method = RequestMethod.GET)
    public HashMap<String, String> getCardWithGrades(@PathVariable("studentID") String studenID) {
        return studentService.prepareCardWithGrades(Long.parseLong(studenID));
    }
}
