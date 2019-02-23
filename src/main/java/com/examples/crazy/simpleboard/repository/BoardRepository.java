package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
