package com.pinelabs.groupB.controllers;

import com.pinelabs.groupB.models.Course;
import com.pinelabs.groupB.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController (CourseService courseService) {
        this.courseService = courseService;
    }

    //Create course
    @PostMapping("/addCourses")
    public String addCourse(@RequestBody Course course) {
        courseService.addCourses(course);
        return "Added course with ID: " + course.getId();
    }

    //Get list of all courses
    @GetMapping("/getCourses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    //Get course by ID
    @GetMapping("/getCourses/{id}")
    public Optional<Course> getCourses(@PathVariable int id){
        return courseService.getCourses(id);
    }

    //Get list of courses by status
    @GetMapping("/getCourses/status/{status}")
    public List<Course> getCoursesByStatus (@PathVariable String status)    {
        return courseService.getCoursesByStatus(status);
    }

    //Delete course by ID
    @DeleteMapping("/deleteCourses/{id}")
    public String deleteCourse(@PathVariable int id){
        return courseService.deleteCourse(id);
    }
}
