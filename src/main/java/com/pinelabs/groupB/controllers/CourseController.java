package com.pinelabs.groupB.controllers;

import com.pinelabs.groupB.models.Course;
import com.pinelabs.groupB.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping()
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.addCourses(course), HttpStatus.CREATED);
    }

    //Get list of all courses
    @GetMapping()
    public ResponseEntity<?> getCourses(){
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }

    //Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourses(@PathVariable int id){
        return new ResponseEntity<>(courseService.getCourses(id), HttpStatus.OK);
    }

    //Get list of courses by status
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getCoursesByStatus (@PathVariable String status)    {
        return new ResponseEntity<>(courseService.getCoursesByStatus(status), HttpStatus.OK);
    }

    //Delete course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        return new ResponseEntity<>(courseService.deleteCourse(id), HttpStatus.ACCEPTED);
    }
}
