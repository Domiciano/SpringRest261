package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course") // -> Solo tiene que ver con la URL
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // http://localhost:8080/course/list
    @GetMapping("/list")
    public String list(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute(
                "courses",
                courses
        );
        return "course/courselist";
    }

}
