package com.diary.controller;

import com.diary.model.Subject;
import com.diary.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-06.
 */

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Subject> findAll(){return subjectService.findAll();}

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Subject addNewSubject(@RequestBody Subject subject){
       return subjectService.addNewSubject(subject);
    }


    @RequestMapping(path = "/{subjectID}/teacher/{teacherID}", method = RequestMethod.PUT)
    public void addTeacherToSubject(@PathVariable("subjectID") String subjectID, @PathVariable("teacherID")String teacherID){
        subjectService.addSubjectToTeacher(Long.valueOf(subjectID),Long.valueOf(teacherID));
    }}
