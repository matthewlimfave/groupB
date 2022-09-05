package com.pinelabs.groupB.controllers;

import com.pinelabs.groupB.models.Student;
import com.pinelabs.groupB.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping()
    public ResponseEntity<?> addStudents(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudents(student), HttpStatus.CREATED);
    }

    //Get list of all students
    @GetMapping()
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK) ;
    }

    //Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudents(@PathVariable int id){
        return new ResponseEntity<>(studentService.getStudents(id), HttpStatus.OK);
    }

    //Get list if students by status
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getStudentsByStatus(@PathVariable String status)   {
        return new ResponseEntity<>(studentService.getStudentsByStatus(status), HttpStatus.OK);
    }

    //Delete student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.ACCEPTED);
    }
}
