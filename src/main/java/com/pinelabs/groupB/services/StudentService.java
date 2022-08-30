package com.pinelabs.groupB.services;

import com.pinelabs.groupB.models.Student;
import com.pinelabs.groupB.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        student.setCreatedOn(LocalDateTime.now());
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudents(@PathVariable int id){
        return studentRepository.findById(id);
    }

    public String deleteStudent(@PathVariable int id){
        studentRepository.deleteById(id);
        return "Student deleted with ID:" + id;
    }

}
