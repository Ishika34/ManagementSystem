package com.excellarate.practice.services;
import com.excellarate.practice.Exception.StudentNotFound;
import com.excellarate.practice.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStdInfo() throws StudentNotFound;

    Boolean saveStd(Student student);

    void deleteStd(Long id);
}
