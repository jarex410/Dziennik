package com.diary.controller;

import com.diary.model.Grade;
import com.diary.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-06.
 */
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Grade> findAll() {
        return gradeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    @RequestMapping(path = "/{gradeID}/subject/{subjectID}/student/{studentID}", method = RequestMethod.PUT)
    public void addGradeToSubjectAndClass(@PathVariable("gradeID") String gradeID, @PathVariable("subjectID") String subjectID, @PathVariable("studentID") String studentID) {
        gradeService.addGradeToSubjectAndClass(Long.valueOf(gradeID), Long.valueOf(subjectID), Long.valueOf(studentID));
    }
}
