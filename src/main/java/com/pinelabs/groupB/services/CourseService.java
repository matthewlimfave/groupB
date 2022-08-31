package com.pinelabs.groupB.services;

import com.pinelabs.groupB.models.Course;
import com.pinelabs.groupB.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //Create course
    public void addCourses (Course course) {
        course.setCreatedOn(LocalDateTime.now());
        course.setModifiedOn(LocalDateTime.now());
        courseRepository.save(course);
    }
    
    //Get list of all courses
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
    
    //Get course by ID
    public Optional<Course> getCourses(int id)   {
        return courseRepository.findById(id);
    }
    
    //Get list of courses by status
    public List<Course> getCoursesByStatus(String status){
        return courseRepository.findByStatus(status);
    }
    
    //Delete course with ID
    public String deleteCourse(int id){
        courseRepository.deleteById(id);
        return "Course deleted with ID:" + id;
    }
}
