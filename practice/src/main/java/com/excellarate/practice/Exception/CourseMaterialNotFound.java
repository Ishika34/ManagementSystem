package com.excellarate.practice.Exception;

public class CourseMaterialNotFound extends Exception{
    public CourseMaterialNotFound(String courseMNotFound) {
        super(courseMNotFound);
    }
}
