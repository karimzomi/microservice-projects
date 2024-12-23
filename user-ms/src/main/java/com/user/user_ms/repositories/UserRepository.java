package com.user.user_ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.user_ms.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}