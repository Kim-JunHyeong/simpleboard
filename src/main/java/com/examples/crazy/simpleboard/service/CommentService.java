package com.examples.crazy.simpleboard.service;

import com.examples.crazy.simpleboard.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments(Long BoardId);
}
