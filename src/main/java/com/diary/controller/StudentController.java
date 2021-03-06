package com.diary.controller;

import com.diary.dto.GradeDTO;
import com.diary.model.Student;
import com.diary.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @RequestMapping(method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student){
        studentService.create(student);
    }

    @RequestMapping(path = "/class", method = RequestMethod.PUT)
    public void addStudentToClass(@PathParam("classID") String classID, @PathParam("studentID") String studentID) {
        studentService.addStudentToClass(Long.valueOf(classID), Long.valueOf(studentID));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Student> findStudentByClass(@PathParam("classID") String classID) {
        return studentService.findStudentsByClassID(Long.valueOf(classID));
    }

    @RequestMapping(path = "/card/{studentID}", method = RequestMethod.GET)
    public List<GradeDTO> getCardWithGrades(@PathVariable("studentID") String studenID) {
        return studentService.prepareCardWithGrades(Long.parseLong(studenID));
    }
}
