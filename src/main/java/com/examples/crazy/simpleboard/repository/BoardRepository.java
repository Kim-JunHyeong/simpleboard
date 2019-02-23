package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "SELECT b FROM Board b join fetch b.boardBody " +
            "join fetch b.category join fetch b.user join fetch b.files " +
            "where b.id = :id")
    Board findBoardById(@Param("id") Long id);
}
