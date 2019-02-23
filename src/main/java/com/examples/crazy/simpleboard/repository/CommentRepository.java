package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
