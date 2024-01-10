package me.dyjeong365.springbootdeveloper.repository;

import java.util.Optional;
import me.dyjeong365.springbootdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
