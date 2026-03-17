package edu.co.icesi.introspringboot.repository;

import edu.co.icesi.introspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
