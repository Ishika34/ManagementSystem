package com.excellarate.practice.services;

import com.excellarate.practice.dto.CourseMapperDto;
import com.excellarate.practice.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICourseService {
    List<Course> displayCourse();

   Boolean saveCourse(Course course);

    void deleteCourse(Long id);

    List<CourseMapperDto> findAllCourseAndCourseMaterial();

    Boolean saveCourseWithCourseMaterial(Course course);

    Course saveCourseAndStudent(Course course);

//    List<Course> findAll();
}
