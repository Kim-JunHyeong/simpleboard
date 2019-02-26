package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Board;
import com.examples.crazy.simpleboard.domain.BoardBody;
import com.examples.crazy.simpleboard.domain.FileInfo;
import com.examples.crazy.simpleboard.dto.BoardsDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardBodyRepository boardBodyRepository;

    @Test
    public void lazyTest() {
        PageRequest of = PageRequest.of(0, 10);
        Page<Board> all = boardRepository.findAll(of);

        for(Board board : all) {
            System.out.println(board.getClass().getName());
        }
    }

    @Test
    public void 카테고리별상품목록구하기() {
        PageRequest of = PageRequest.of(0, 10);

        Page<BoardsDto> all = boardRepository.findBoardsByCategoryId(1L, of);

        all.forEach(board -> {
            System.out.println(board.getTitle());
            System.out.println(board.getReadCount());
            System.out.println(board.getMemberAlias());
        });

    }

    @Test
    public void 모든상품목록구하기() {
        PageRequest of = PageRequest.of(0, 10);

        Page<BoardsDto> all = boardRepository.findBoardAll(of);

        all.forEach(board -> {
            System.out.println(board.getMemberAlias());
        });
    }

    @Test
    public void baseTimeEntityCheck() {
        // given
        LocalDateTime now = LocalDateTime.now();

        BoardBody boardBody = new BoardBody();
        boardBody.setContent("체크할거야");
        BoardBody savedBoardBody = boardBodyRepository.save(boardBody);

        Board board = new Board();
        board.setTitle("baseTimeCheck");
        board.setBoardBody(savedBoardBody);

        boardRepository.save(board);

        // when
        List<Board> boards = boardRepository.findAll();

        // then
        Board board1 = boards.get(3);
        assertThat(board1.getCreatedDate()).isAfter(now);
        assertThat(board1.getModifiedDate()).isAfter(now);
    }

    @Test
    public void getBoard() {
        Board board = boardRepository.findBoardById(1L);
        System.out.println(board.getBoardBody().getContent());
        System.out.println(board.getCategory().getName());
        System.out.println(board.getMember().getAlias());

        Set<FileInfo> files = board.getFiles();
        for (FileInfo fileInfo : files) {
            System.out.println(fileInfo.getStoredFileName());
        }
    }
}