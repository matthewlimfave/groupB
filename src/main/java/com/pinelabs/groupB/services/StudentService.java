package com.pinelabs.groupB.services;

import com.pinelabs.groupB.models.Student;
import com.pinelabs.groupB.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    //Create student
    public Student addStudents(Student student) {
        student.setId(sequenceGenerator.generateSequence(student.SEQUENCE_NAME));
        student.setCreatedOn(LocalDateTime.now());
        student.setModifiedOn(LocalDateTime.now());
        return studentRepository.save(student);
    }

    //Get list of all students
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    //Get student by ID
    public Optional<Student> getStudents(int id){
        return studentRepository.findById(id);
    }

    //Get list of students by status
    public List<Student> getStudentsByStatus(String status){
        return studentRepository.findByStatus(status);
    }

    //Delete student with ID
    public String deleteStudent(int id){
        studentRepository.deleteById(id);
        return "Student deleted with ID:" + id;
    }

}
