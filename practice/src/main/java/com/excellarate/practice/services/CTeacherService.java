package com.excellarate.practice.services;

import com.excellarate.practice.Exception.TeacherNotFound;
import com.excellarate.practice.model.Course;
import com.excellarate.practice.model.Teacher;
import com.excellarate.practice.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CTeacherService implements ITeacherService{
    @Autowired
    TeacherRepo teacherRepo;
    @Override
    public List<Teacher> getTeacherInfo() throws TeacherNotFound {
        List<Teacher> teacher= teacherRepo.findAll();
        if (!teacher.isEmpty()) {
            return teacher;
        } else {
            throw new TeacherNotFound("Teacher not found");
        }
    }

    @Override
    public Boolean saveTeacher(Teacher teacher) {
        Teacher teacher1=new Teacher();
        List<Course> list=new ArrayList<>();
        if(teacher!=null) {
            if(teacher.getId()!=null)
            {
                teacher1.setId(teacher.getId());
            }
            teacher1.setFirstName(teacher.getFirstName());
            teacher1.setLastName(teacher.getLastName());
            teacher1.setEmail(teacher.getEmail());

        }
        for(Course course: teacher.getCourses())
        {
            Course course1=new Course();

            if(course.getId()!=null)
            {
                course1.setId(course1.getId());
            }
            course1.setCourseTitle(course.getCourseTitle());
            course1.setCredit(course.getCredit());
            list.add(course1);
        }
        teacher1.setCourses(list);

//        if(teacher.getId() != null){
//            teacher1.setId(teacher.getId());
//        }
        Teacher save = teacherRepo.save(teacher1);
        if (save != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public Teacher saveTeacherWithCourse(Teacher teacher) {
        List<Course> list=new ArrayList<>();
        for(Course course:teacher.getCourses()){
            course.setTeacher(teacher);
            Course course1=new Course();
            course1.setCourseTitle(course.getCourseTitle());
            course1.setCredit(course.getCredit());
            list.add(course1);
        }
        teacher.setCourses(list);
        Teacher save = teacherRepo.save(teacher);
        return save;
    }
}
