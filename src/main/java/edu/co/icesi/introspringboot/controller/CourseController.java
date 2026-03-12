package edu.co.icesi.introspringboot.controller;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Lesson 15: GET /courses/by-professor?professorName=Juan+Perez&page=0&size=5
    @GetMapping("/courses/by-professor")
    public Page<Course> getCoursesByProfessor(
            @RequestParam String professorName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return courseService.getCoursesByProfessor(professorName, page, size);
    }
}
