package com.pinelabs.groupB.controllers;

import com.pinelabs.groupB.models.Student;
import com.pinelabs.groupB.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Added student with ID: " + student.getId();
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudents/{id}")
    public Optional<Student> getStudents(@PathVariable int id){
        return studentService.getStudents(id);
    }

    @DeleteMapping("/deleteStudents/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }
}
