package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;

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
}