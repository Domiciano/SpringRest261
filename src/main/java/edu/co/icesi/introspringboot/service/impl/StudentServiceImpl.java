package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.entity.Student;
import edu.co.icesi.introspringboot.repository.CourseRepository;
import edu.co.icesi.introspringboot.repository.EnrollmentRepository;
import edu.co.icesi.introspringboot.repository.StudentRepository;
import edu.co.icesi.introspringboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              CourseRepository courseRepository,
                              EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Student findStudentByCode(String code) {
        return null;
    }

    @Override
    public List<Student> getStudentsByCourseName(String courseName) {
        return null;
    }

    @Override
    public void deleteStudentByCode(String code) {
    }

    @Override
    public void enrollStudentInCourse(String studentCode, String courseName) {
    }

    @Override
    public void unenrollStudentFromCourse(String studentCode, String courseName) {
    }
}
