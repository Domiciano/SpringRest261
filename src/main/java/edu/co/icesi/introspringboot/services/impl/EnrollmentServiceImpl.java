package edu.co.icesi.introspringboot.services.impl;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.entity.Enrollment;
import edu.co.icesi.introspringboot.entity.Student;
import edu.co.icesi.introspringboot.entity.keys.StudentCourseId;
import edu.co.icesi.introspringboot.repository.CourseRepository;
import edu.co.icesi.introspringboot.repository.EnrollmentRepository;
import edu.co.icesi.introspringboot.repository.StudentRepository;
import edu.co.icesi.introspringboot.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Transactional
    @Override
    public Enrollment enroll(Integer courseId, Integer studentId){
        Optional<Course> course = courseRepository.findById(courseId);
        course.orElseThrow( ()-> new RuntimeException("Curso no existe") ); //Lanzar excepción
        Optional<Student> student = studentRepository.findById(studentId);
        student.orElseThrow( ()-> new RuntimeException("Estudiante no existe") ); //Lanzar excepción
        Enrollment enrollment = new Enrollment();
        StudentCourseId id  = new StudentCourseId();
        id.setStudentId(studentId);
        id.setCourseId(courseId);
        enrollment.setId(id);
        enrollment.setCourse(course.get());
        enrollment.setStudent(student.get());
        Enrollment enrollmentPersist =  enrollmentRepository.save(enrollment);
        return enrollmentPersist;
        //throw new RuntimeException("Fallo a propósito");
    }
}
