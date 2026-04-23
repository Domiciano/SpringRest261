package edu.co.icesi.introspringboot.api.v1.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
    private String name;
    private int credits;
    private String professorName;
}
