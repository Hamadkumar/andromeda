package com.io.andromeda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.andromeda.domain.User;

/**
 * @author hamad
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
