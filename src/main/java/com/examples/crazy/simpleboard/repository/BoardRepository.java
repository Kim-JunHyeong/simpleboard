package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Board;
import com.examples.crazy.simpleboard.dto.BoardsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 게시글 상세보기
    @Query(value = "SELECT b FROM Board AS b JOIN FETCH b.boardBody " +
            "JOIN FETCH b.category JOIN FETCH b.user JOIN FETCH b.files " +
            "where b.id = :id")
    Board findBoardById(@Param("id") Long id);

    // 모든 게시글 불러오기
    @Query(value = "SELECT new com.examples.crazy.simpleboard.dto.BoardsDto " +
            "(b.id, b.title, u.alias, b.readCount, b.createdDate) " +
            "FROM Board AS b INNER JOIN User AS u ON b.user.id = u.id " +
            "ORDER BY b.parent_board_id DESC, b.replySeq ASC")
    Page<BoardsDto> findBoardAll(Pageable pageable);

    // 카테고리를 구분으로 게시글 불러오기
    @Query(value = "SELECT new com.examples.crazy.simpleboard.dto.BoardsDto " +
            "(b.id, b.title, u.alias, b.readCount, b.createdDate) " +
            "FROM Board AS b INNER JOIN User AS u ON b.user.id = u.id " +
            "WHERE b.category.id = :categoryId ORDER BY b.parent_board_id DESC, b.replySeq ASC")
    Page<BoardsDto> findBoardsByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);
}
