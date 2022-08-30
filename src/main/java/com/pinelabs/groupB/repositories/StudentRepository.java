package com.pinelabs.groupB.repositories;

import com.pinelabs.groupB.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
}
