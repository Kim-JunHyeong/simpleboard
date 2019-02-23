package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
