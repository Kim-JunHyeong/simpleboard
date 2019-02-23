package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Board;
import com.examples.crazy.simpleboard.domain.Comment;
import com.examples.crazy.simpleboard.domain.FileInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void lazyTest() {
        PageRequest of = PageRequest.of(0, 10);
        Page<Board> all = boardRepository.findAll(of);

        for(Board board : all) {
            System.out.println(board.getClass().getName());
        }
    }

    @Test
    public void getBoard() {
        Board board = boardRepository.findBoardById(1L);
        System.out.println(board.getBoardBody().getContent());
        System.out.println(board.getCategory().getName());
        System.out.println(board.getUser().getAlias());

        Set<FileInfo> files = board.getFiles();
        for (FileInfo fileInfo : files) {
            System.out.println(fileInfo.getStoredFileName());
        }
    }
}