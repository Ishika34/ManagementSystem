package com.excellarate.practice.controller;


import com.excellarate.practice.model.Student;
import com.excellarate.practice.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StdController {
    @Autowired
    IStudentService iStudentService;


    @GetMapping("/getStdInfo")
    public ResponseEntity<List<Student>> getStdInfo() throws Exception{
        try {
            List<Student> stdInfo = iStudentService.getStdInfo();
            return new ResponseEntity<>(stdInfo,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/saveStd")
    public ResponseEntity<Boolean> saveStd(@RequestBody Student student) throws Exception{
        try {
            Boolean savedata = iStudentService.saveStd(student);
            if (savedata != null) {
                Boolean truee = true;
                return ResponseEntity.status(HttpStatus.OK).body(truee);
            } else {
                Boolean false1 = false;
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false1);
            }
        } finally {

        }
    }


    @DeleteMapping("/deleteStd/{id}")
    public void dltStd(@PathVariable Long id){
        iStudentService.deleteStd(id);
    }
}
