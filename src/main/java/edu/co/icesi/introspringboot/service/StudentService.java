package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Student;

import java.util.List;

public interface StudentService {

    Student findStudentByCode(String code);

    List<Student> getStudentsByCourseName(String courseName);

    void deleteStudentByCode(String code);

    void enrollStudentInCourse(String studentCode, String courseName);

    void unenrollStudentFromCourse(String studentCode, String courseName);
}
