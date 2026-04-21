package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.repository.CourseRepository;
import edu.co.icesi.introspringboot.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @PreAuthorize("hasAuthority('READ_COURSE')")
    public Page<Course> getCoursesByProfessor(String professorName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return courseRepository.findByProfessor_Name(professorName, pageable);
    }

    @Override
    @PreAuthorize("hasAuthority('READ_COURSE')")
    public List<Course> getAllCourses() {
        List<Course> result = new ArrayList<>();
        courseRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    @PreAuthorize("hasAuthority('READ_COURSE')")
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));
    }

    @Override
    @PreAuthorize("hasAuthority('READ_COURSE')")
    public List<Course> getCoursesByCredits(int credits, int page, int quantity) {
        Pageable pageable = PageRequest.of(page, quantity);
        return courseRepository.findByCreditsEquals(credits, pageable);
    }

    @Override
    @PreAuthorize("hasAuthority('CREATE_COURSE')")
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @PreAuthorize("hasAuthority('DELETE_COURSE')")
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }
}
