package com.examples.crazy.simpleboard.service;

import com.examples.crazy.simpleboard.domain.Board;
import com.examples.crazy.simpleboard.dto.BoardsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    // 모든 게시글
    Page<BoardsDto> getBoards(Pageable pageable);
    // 카테고리 별 상품 목록
    Page<BoardsDto> getBoardsByCategory(Long categoryId, Pageable pageable);
    // 게시글 1개(카테고리를 추가하자)
    Board getBoard(Long id);
}
