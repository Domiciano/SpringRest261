package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByName(String name);

    List<Course> findByProfessor_NameOrderByName(String name);

    // Lesson 15: Limiting results
    Optional<Course> findFirstByOrderByNameAsc();

    List<Course> findTop2ByOrderByCreditsDesc();

    List<Course> findByCreditsBetween(int minCredits, int maxCredits);

    List<Course> findByCreditsOrderByNameAsc(int credits);

    // Lesson 15: Pagination
    Page<Course> findByProfessor_Name(String professorName, Pageable pageable);
}
