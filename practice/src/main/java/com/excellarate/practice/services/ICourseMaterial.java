package com.excellarate.practice.services;

import com.excellarate.practice.Exception.CourseMaterialNotFound;
import com.excellarate.practice.model.CourseMaterial;

import java.util.List;

public interface ICourseMaterial {
    List<CourseMaterial> CourseMaterialInfo() throws CourseMaterialNotFound;

    Boolean saveCourseAndCourseMaterial(CourseMaterial courseMaterial);
}
