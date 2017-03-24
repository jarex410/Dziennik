package com.diary.controller;

import com.diary.model.Grade;
import com.diary.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by JaroLP on 2016-11-06.
 */
@RestController
@RequestMapping("/grade")
@CrossOrigin
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Grade addGrade(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Grade> getGradeByStudentAndSubject(@PathParam("studentId") String studentId, @PathParam("subjectID") String subjectId) {
        return gradeService.findGradesByStudentAndSubject(Long.valueOf(studentId), Long.valueOf(subjectId));
    }

}
