package com.zee.zee5app.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;
//Interface->add jpa repository->change type to entity(Register) and type to primary key(string)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
Boolean existsByEmail(String email);
Boolean existsByContactNo(BigDecimal contactNo);
Boolean existsByEmailAndContactNo(String email,BigDecimal contactNo);
Optional<User> findByUsername(String username);
Boolean existsByUsername(String username);
}
