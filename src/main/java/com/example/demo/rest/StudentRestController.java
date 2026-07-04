package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

//    define @PostCOnstructor to load the student data... only once!!

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Daniel", "King"));
        theStudents.add(new Student("James", "Brown"));
        theStudents.add(new Student("Mary", "Smit"));

    }


    //    define endpoint for "/studnets"
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

//    define endpoint for "/students/{studentId}"

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

//        just index into the list
        return theStudents.get(studentId);
    }
}
