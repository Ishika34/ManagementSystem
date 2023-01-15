package com.excellarate.practice.controller;


import com.excellarate.practice.Exception.TeacherNotFound;
import com.excellarate.practice.model.Teacher;
import com.excellarate.practice.services.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    ITeacherService iTeacherService;

    @GetMapping("/getTeacherInfo")
    public List<Teacher> getTeacherInfo() throws TeacherNotFound {
        List<Teacher> teacherInfo = iTeacherService.getTeacherInfo();
        return teacherInfo;
    }

    @PutMapping("/saveTeachers")
    public Boolean saveTeacher(@RequestBody Teacher teacher) {
        Boolean savedata = iTeacherService.saveTeacher(teacher);
        if (savedata != null) {
            return true;
        } else {

            return false;
        }

    }

    @DeleteMapping("/deleteTeacher/{id}")
    public void dltTeacher(@PathVariable Long id) {
        iTeacherService.deleteTeacher(id);
    }

    @PutMapping("/saveTeacherWithCourse")
    public Teacher saveTeacherWithCourse(@RequestBody Teacher teacher) {
        return iTeacherService.saveTeacherWithCourse(teacher);
    }
}
