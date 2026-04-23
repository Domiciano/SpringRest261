package edu.co.icesi.introspringboot.api.v1;

import edu.co.icesi.introspringboot.api.v1.dto.CourseRequest;
import edu.co.icesi.introspringboot.api.v1.dto.CourseResponse;
import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.repository.CourseRepository;
import edu.co.icesi.introspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


//GET, POST, PUT, PATCH, DELETE
@RestController
@RequestMapping("/api/v1/courses")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getCourses() {
        List<CourseResponse> courses = courseService.getAllCoursesAPI();
        return ResponseEntity
                .status(200)
                .header(
                        "CalderonHeader",
                        "RestEsLoMejor"
                )
                .body(courses);
    }

    //POST
    // http://localhost:8081/api/v1/courses
    /*
    Body:
    {
        "name":"Nueva Materia Espectacular",
        "credits":6,
        "professor":{"id":1}
    }
    */
    @PostMapping
    public ResponseEntity<?> saveCourse(
            @RequestBody CourseRequest course
    ) {
        try{
            courseService.saveAPI(course);
            return ResponseEntity.status(201).build();
        }catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }




}
