package com.diary.controller;

import com.diary.model.SchoolClass;
import com.diary.services.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * Created by JaroLP on 2016-11-02.
 */


@EnableWebMvc
@RestController
@RequestMapping("/class")
@CrossOrigin
public class SchoolClassController {

    @Autowired
    SchoolClassService schoolClassService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<SchoolClass> getClassById(@PathVariable("id") Long id) {
        SchoolClass schoolClass = schoolClassService.getClassByID(id);
        return new ResponseEntity<SchoolClass>(schoolClass, HttpStatus.OK) ;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createClass(@RequestBody SchoolClass schoolClass) {
        schoolClassService.create(schoolClass);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<SchoolClass> findAll(){
        List<SchoolClass> schoolClasses = schoolClassService.findAll();
        return schoolClasses;
    }

}
