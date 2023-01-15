package com.excellarate.practice.services;

import com.excellarate.practice.Exception.TeacherNotFound;
import com.excellarate.practice.model.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> getTeacherInfo() throws TeacherNotFound;

    Boolean saveTeacher(Teacher teacher);

    void deleteTeacher(Long id);


    Teacher saveTeacherWithCourse(Teacher teacher);
}
