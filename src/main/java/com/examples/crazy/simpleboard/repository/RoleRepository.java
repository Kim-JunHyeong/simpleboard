package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Set<Role> findByName(String name);
}
