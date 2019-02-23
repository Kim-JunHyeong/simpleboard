package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.BoardBody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardBodyRepository extends JpaRepository<BoardBody, Long> {
}
