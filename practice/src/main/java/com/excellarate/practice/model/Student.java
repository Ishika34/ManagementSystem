package com.excellarate.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String aadharNo;
//    @JsonManagedReference
    @ManyToMany(mappedBy = "studentList",cascade = CascadeType.ALL)
    public List<Course> courseList;

}
