package com.examples.crazy.simpleboard.service;

import com.examples.crazy.simpleboard.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    Page<Board> getBoards(Pageable pageable);

    Board getBoard(Long id);
}
