package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.Course;
import edu.co.icesi.introspringboot.entity.Enrollment;
import edu.co.icesi.introspringboot.entity.Student;
import edu.co.icesi.introspringboot.entity.keys.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, StudentCourseId> {

    // Lesson 17: Check enrollment existence
    boolean existsByStudentAndCourse(Student student, Course course);

    // Lesson 17: Find enrollment by student and course
    Optional<Enrollment> findByStudentAndCourse(Student student, Course course);
}
