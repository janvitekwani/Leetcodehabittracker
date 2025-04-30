package com.example.leetcodehabitfinal.repository;




import com.example.leetcodehabitfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);  //  find by the user name
    Optional<User> findByEmail(String email);  // find by email
}

