package com.pinelabs.groupB.repositories;

import com.pinelabs.groupB.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, Integer> {
    List<Student> findByStatus(String status);
}
