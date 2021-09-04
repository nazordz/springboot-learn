package com.lesson.learn.models.repos;

import java.util.Optional;

import com.lesson.learn.models.entities.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, String> {
    
    Optional<AppUser> findByEmail(String email);
}
