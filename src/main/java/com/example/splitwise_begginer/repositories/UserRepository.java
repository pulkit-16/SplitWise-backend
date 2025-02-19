package com.example.splitwise_begginer.repositories;

import com.example.splitwise_begginer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
      User save(User entity);

    @Override
    Optional<User> findById(Long aLong);
}
