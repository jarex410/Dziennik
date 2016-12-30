package com.diary.controller;

import com.diary.model.Subject;
import com.diary.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-06.
 */

@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {

    @Autowired
    SubjectService subjectService;

/*    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Subject> findAll(){return subjectService.findAll();}*/

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Subject addNewSubject(@RequestBody Subject subject){
       return subjectService.addNewSubject(subject);
    }

    @RequestMapping(path = "/{subjectID}/teacher/{teacherID}", method = RequestMethod.PUT)
    public void addTeacherToSubject(@PathVariable("subjectID") String subjectID, @PathVariable("teacherID")String teacherID){
        subjectService.addSubjectToTeacher(Long.valueOf(subjectID),Long.valueOf(teacherID));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{subjectID}/class/{classID}")
    public void addTeacherToClass(@PathVariable("classID") String classID, @PathVariable("subjectID") String subjectID){
        subjectService.addSubjectToClass(Long.valueOf(classID), Long.valueOf(subjectID));}

    @RequestMapping(path = "/{subjectID}/student/{studentID}/grade/{gradeID}", method = RequestMethod.PUT)
    public void addGradeToSubjectAndClass(@PathVariable("gradeID") String gradeID, @PathVariable("subjectID") String subjectID, @PathVariable("studentID") String studentID) {
        subjectService.addGradeToSubjectAndStudent(Long.valueOf(gradeID), Long.valueOf(subjectID), Long.valueOf(studentID));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Subject> getSubjectByTeacher(@PathParam("teacherID") String teacherID) {
        return subjectService.getSubjectByTeacherId(teacherID);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{subjectID}")
    @ResponseBody
    public Subject getById(@PathVariable("subjectID") String subjectID) {
        return subjectService.getById(Long.valueOf(subjectID));
    }

}
