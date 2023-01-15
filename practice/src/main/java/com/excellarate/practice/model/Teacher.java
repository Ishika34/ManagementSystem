package com.excellarate.practice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name="teacherId",referencedColumnName = "id")//not good programming practice
    private List<Course> courses;

}
