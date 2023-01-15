package com.excellarate.practice.services;

import com.excellarate.practice.Exception.StudentNotFound;
import com.excellarate.practice.model.Student;
import com.excellarate.practice.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CStudentService implements IStudentService{
    @Autowired
    StudentRepo studentRepo;
    @Override
    public List<Student> getStdInfo() throws StudentNotFound {
        List<Student> studentList=studentRepo.findAll();
        if(!studentList.isEmpty()){
            return studentList;
        }
        else{
            throw new StudentNotFound("Student not Found");
        }

    }

    @Override
    public Boolean saveStd(Student student) {
        Student student1 = new Student();
        if(student.getId() != null){
            student1.setId(student.getId());
        }
        Student save = studentRepo.save(student);
        if (save != null) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void deleteStd(Long id) {

        studentRepo.deleteById(id);
    }
}
