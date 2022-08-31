package com.pinelabs.groupB.repositories;

import com.pinelabs.groupB.models.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, Integer> {
    List<Course> findByStatus(String status);
}
