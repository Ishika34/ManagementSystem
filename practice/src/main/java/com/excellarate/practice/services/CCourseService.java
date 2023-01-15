package com.excellarate.practice.services;

import com.excellarate.practice.Exception.NoCourseFound;
import com.excellarate.practice.Mapper.CourseMapper;
import com.excellarate.practice.dto.CourseMapperDto;
import com.excellarate.practice.model.Course;
import com.excellarate.practice.model.CourseMaterial;
import com.excellarate.practice.model.Student;
import com.excellarate.practice.model.Teacher;
import com.excellarate.practice.repository.CourseMaterialRepo;
import com.excellarate.practice.repository.CourseRepo;
import com.excellarate.practice.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CCourseService implements ICourseService{
   @Autowired
    CourseRepo courseRepo;


    @Override
    public List<Course> displayCourse() {
        List<Course> courseList = courseRepo.findAll();
      if(!courseList.isEmpty()){
          return courseList;
      }
      else{
          throw new NoCourseFound("No Course Found");
      }

    }

    @Override
    public Boolean saveCourse(Course course) {
        Course course1=new Course();
        if(course.getId()!=null){
            course1.setId(course.getId());
        }
        Course save = courseRepo.save(course);
        if (save != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
    @Override
    public List<CourseMapperDto> findAllCourseAndCourseMaterial(){
        List<CourseMapperDto> list = new ArrayList<>();
        List<CourseMapper> cmd = courseRepo.getDetails();
        for(CourseMapper courseMapper:cmd){
            CourseMapperDto courseMapperDto = new CourseMapperDto();
            courseMapperDto.setCourseName(courseMapper.getCourseName());
            courseMapperDto.setCredit(courseMapper.getCourseCredit());
            courseMapperDto.setUrl(courseMapper.getCourseMaterialUrl());
            list.add(courseMapperDto);
        }
        return list;
    }

    @Override
    public Boolean saveCourseWithCourseMaterial(Course course){
        CourseMaterial material = new CourseMaterial();
        material.setUrl(course.getCourseMaterial().getUrl());
        Course course1 = new Course();
        course1.setCourseTitle(course1.getCourseTitle());
        course1.setCredit(course1.getCredit());
        material.setCourse(course1);
        course1.setCourseMaterial(material);
        Course save = courseRepo.save(course);
        if(save!=null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Course saveCourseAndStudent(Course course) {
        Course course1 = new Course();
        course1.setCourseTitle(course.getCourseTitle());
        course1.setCredit(course.getCredit());
        course1.setTeacher(course.getTeacher());
        course1.setCourseMaterial(course.getCourseMaterial());
        List<Student> student1= new ArrayList<>();
        for (Student student : course.getStudentList()) {
            Student student2 = new Student();
            student2.setFirstName(student.getFirstName());
            student2.setLastName(student.getLastName());
            student2.setEmail(student.getEmail());
            student1.add(student2);
        }
        course1.setStudentList(student1);

        return  courseRepo.save(course1);
    }


}






