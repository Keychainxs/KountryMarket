package  com.kountrymarket.conveniencestore.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kountrymarket.conveniencestore.model.User;

public interface UserRepository extends MongoRepository<User,String> {
   
    Optional<User> findByUsername(String username);

}
