package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
