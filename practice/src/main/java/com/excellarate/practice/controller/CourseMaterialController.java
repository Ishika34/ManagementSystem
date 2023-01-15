package com.excellarate.practice.controller;


import com.excellarate.practice.Exception.CourseMaterialNotFound;
import com.excellarate.practice.model.CourseMaterial;
import com.excellarate.practice.services.ICourseMaterial;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseMaterialController {
    @Autowired
    ICourseMaterial iCourseMaterial;
    @PutMapping("/save-courseMaterial-course")
    public Boolean saveCourseMaterialAndCourse(@RequestBody CourseMaterial courseMaterial)
    {
       return iCourseMaterial.saveCourseAndCourseMaterial(courseMaterial);
    }
    @GetMapping("/get-courseMaterial")
    public List<CourseMaterial> CourseMaterialInfo() throws CourseMaterialNotFound {
        List<CourseMaterial> courseMaterial = iCourseMaterial.CourseMaterialInfo();
               return courseMaterial;
    }
}
