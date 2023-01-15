package com.excellarate.practice.services;

import com.excellarate.practice.Exception.CourseMaterialNotFound;
import com.excellarate.practice.model.Course;
import com.excellarate.practice.model.CourseMaterial;
import com.excellarate.practice.repository.CourseMaterialRepo;
import com.excellarate.practice.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CCourseMaterial implements ICourseMaterial {
    @Autowired
    CourseMaterialRepo courseMaterialRepo;
    @Autowired
    CourseRepo courseRepo;


    @Override
    public List<CourseMaterial> CourseMaterialInfo() throws CourseMaterialNotFound {
        List<CourseMaterial> courseMaterial = courseMaterialRepo.findAll();
        if(!courseMaterial.isEmpty()){
            return courseMaterial;
        }
        else{
            throw new CourseMaterialNotFound("nothing Found");
        }
    }

    @Override
    public Boolean saveCourseAndCourseMaterial(CourseMaterial courseMaterial) {
        CourseMaterial courseMaterial1=new CourseMaterial();
        Course  course = new Course();
        Course save=null;
        if(courseMaterial.getCourse()!=null){
//            course.setCredit(courseMaterial.getCourse().getCredit());
//            course.setCourseTitle(courseMaterial.getCourse().getCourseTitle());
          save=courseRepo.save(courseMaterial.getCourse());
        }
//       courseMaterial1.setUrl(courseMaterial.getUrl());
        courseMaterial1.setCourse(save);
        CourseMaterial save1 = courseMaterialRepo.save(courseMaterial);
       if(save1!=null){
           return true;
       }
       else{
           return false;
       }
    }
}
