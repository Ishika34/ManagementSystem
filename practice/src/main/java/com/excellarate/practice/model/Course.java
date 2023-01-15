package com.excellarate.practice.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CourseTitle;
    private Integer credit;
    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id",referencedColumnName = "id")
    @JsonBackReference
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="student_course",
           joinColumns = @JoinColumn(
                   name="course_id",referencedColumnName = "id"
           ),
        inverseJoinColumns = @JoinColumn(
                name="student_id",referencedColumnName = "id"
        ))
    private List<Student> studentList;
}


