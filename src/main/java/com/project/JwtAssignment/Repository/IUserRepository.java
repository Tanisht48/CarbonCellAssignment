package com.project.JwtAssignment.Repository;

import com.project.JwtAssignment.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,String> {

    public Optional<User> findByEmail(String email);
}
