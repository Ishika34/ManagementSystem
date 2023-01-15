package com.excellarate.practice.controller;

import com.excellarate.practice.dto.CourseMapperDto;
import com.excellarate.practice.model.Course;
import com.excellarate.practice.services.ICourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    ICourseService iCourseService;

    @GetMapping("/displayCourse")
    public ResponseEntity<List<Course>> displayCourse() {
        List<Course> courseList = iCourseService.displayCourse();
        return ResponseEntity.status(HttpStatus.OK).body(courseList);
    }

    @PutMapping("/Save-Course")
    public Boolean saveCourse(@RequestBody Course course) {
        Boolean savedata = iCourseService.saveCourse(course);
        if (savedata != null) {
            return true;
        } else {
            return false;
        }

    }

    @DeleteMapping("/deleteCourse/{id}")
    public void dltCourse(@PathVariable Long id) {
        iCourseService.deleteCourse(id);
    }

    @GetMapping("/getCourseandCourseMaterial")
    public List<CourseMapperDto> getDetail() {
        return iCourseService.findAllCourseAndCourseMaterial();
    }

    @PutMapping("/saveCourseAndStudent")
    public Course saveCourseAndStudent(@RequestBody Course course) {
        return iCourseService.saveCourseAndStudent(course);
    }
//    @GetMapping("/getStdCourseInfo")
//    public List<Course> getStdCourseInfo(){
//        return iCourseService.findAll();
//    }
}
