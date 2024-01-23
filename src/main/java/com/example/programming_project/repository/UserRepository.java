package com.example.programming_project.repository;

import com.example.programming_project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    @Query(value = "SELECT * FROM users AS u"
            + " WHERE u.is_general_admin = true"
            + " AND u.username = ?1", nativeQuery = true)
    Optional<User> findGeneralAdmin(String username);
}
