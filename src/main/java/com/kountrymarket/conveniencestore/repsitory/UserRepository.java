package  com.kountrymarket.conveniencestore.repsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kountrymarket.conveniencestore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
   
    Optional<User> findByUsername(String username);
}
