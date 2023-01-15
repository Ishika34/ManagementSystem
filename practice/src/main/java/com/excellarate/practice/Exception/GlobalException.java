package com.excellarate.practice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = NoCourseFound.class)
    public ResponseEntity<String> NoCourseFound(){
        String msg = "No Course Found !!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }
}
