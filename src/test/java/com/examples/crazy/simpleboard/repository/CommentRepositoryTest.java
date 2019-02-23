package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void commentList() {
        List<Comment> comments = commentRepository.findCommentsByBoardId(1L);

        for (Comment comment : comments) {
            System.out.println(comment.getContent());
            System.out.println(comment.getUser().getAlias());
        }
    }
}