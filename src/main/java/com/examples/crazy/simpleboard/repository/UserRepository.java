package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u JOIN FETCH u.roles WHERE u.loginId = :loginId")
    User findByLoginId(@Param("loginId") String loginId);
}
