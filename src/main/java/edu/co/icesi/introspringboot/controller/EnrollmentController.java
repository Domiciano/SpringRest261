package edu.co.icesi.introspringboot.controller;

import edu.co.icesi.introspringboot.service.EnrollmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/enroll")
    public Map<String, String> enroll() {
        enrollmentService.enroll(2, 2);
        return Map.of("resultado", "Matrícula exitosa");
    }

    @GetMapping("/enroll-fail")
    public Map<String, String> enrollFail() {
        try {
            enrollmentService.enrollWithFailure(2, 3);
        } catch (RuntimeException e) {
            return Map.of("error", e.getMessage(), "rollback", "aplicado");
        }
        return Map.of("resultado", "Sin error");
    }

    @GetMapping("/transient-error")
    public Map<String, String> transientError() {
        try {
            enrollmentService.createCourseWithNewProfessor("Curso de prueba");
        } catch (Exception e) {
            return Map.of("error", e.getMessage() != null ? e.getMessage() : e.getClass().getName());
        }
        return Map.of("resultado", "Sin error");
    }
}
