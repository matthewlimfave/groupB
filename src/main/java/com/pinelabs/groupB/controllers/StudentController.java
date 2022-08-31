package com.pinelabs.groupB.controllers;

import com.pinelabs.groupB.models.Student;
import com.pinelabs.groupB.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    //Create student
    @PostMapping("/addStudents")
    public String addStudents(@RequestBody Student student) {
        studentService.addStudents(student);
        return "Added student with ID: " + student.getId();
    }

    //Get list of all students
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //Get student by ID
    @GetMapping("/getStudents/{id}")
    public Optional<Student> getStudents(@PathVariable int id){
        return studentService.getStudents(id);
    }

    //Get list if students by status
    @GetMapping("/getStudents/status/{status}")
    public List<Student> getStudentsByStatus(@PathVariable String status)   {
        return studentService.getStudentsByStatus(status);
    }

    //Delete student by ID
    @DeleteMapping("/deleteStudents/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }
}
