package ua.ivashchuk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ivashchuk.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmail(String email);
}
