package com.excellarate.practice.Exception;

public class NoCourseFound extends RuntimeException{
    public NoCourseFound(String no_course_found) {
        super(no_course_found);
    }
}
