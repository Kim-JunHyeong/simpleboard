package com.examples.crazy.simpleboard.service.impl;

import com.examples.crazy.simpleboard.domain.Board;
import com.examples.crazy.simpleboard.repository.BoardRepository;
import com.examples.crazy.simpleboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoards(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Board getBoard(Long id) {
        Board storedBoard = boardRepository.findBoardById(id);
        storedBoard.setReadCount(storedBoard.getReadCount() + 1);

        return storedBoard;
    }
}
