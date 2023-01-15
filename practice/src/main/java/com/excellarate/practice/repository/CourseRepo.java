package com.excellarate.practice.repository;

import com.excellarate.practice.Mapper.CourseMapper;
import com.excellarate.practice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
List<CourseMapper> getDetails();
}
