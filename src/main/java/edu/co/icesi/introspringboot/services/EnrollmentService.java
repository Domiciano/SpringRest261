package edu.co.icesi.introspringboot.services;

import edu.co.icesi.introspringboot.entity.Enrollment;

public interface EnrollmentService {
    Enrollment enroll(Integer courseId, Integer studentId);
}
