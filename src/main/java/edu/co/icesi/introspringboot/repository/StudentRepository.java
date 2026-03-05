package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //SELECT * FROM students WHERE code="A00234245"
    Optional<Student> findByCode(String code);

    List<Student> findByProgram(String program);

}