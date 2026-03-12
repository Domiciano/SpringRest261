package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findByName(String name);

    List<Course> findByProfessor_NameOrderByName(String name);

    List<Course> findByCreditsEquals(int credits, Pageable pageable);
}
