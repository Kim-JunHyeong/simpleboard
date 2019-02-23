package com.examples.crazy.simpleboard.service.impl;

import com.examples.crazy.simpleboard.domain.Comment;
import com.examples.crazy.simpleboard.repository.CommentRepository;
import com.examples.crazy.simpleboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Comment> getComments(Long boardId) {

        return commentRepository.findCommentsByBoardId(boardId);
    }
}
