package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c FROM Comment c join fetch c.member " +
            "WHERE c.board.id = :boardId order by c.parent_comment_id DESC, c.id ASC")
    List<Comment> findCommentsByBoardId(@Param("boardId") Long boardId);
}
