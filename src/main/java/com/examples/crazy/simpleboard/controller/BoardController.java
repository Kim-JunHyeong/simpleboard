package com.examples.crazy.simpleboard.controller;

import com.examples.crazy.simpleboard.domain.Comment;
import com.examples.crazy.simpleboard.service.BoardService;
import com.examples.crazy.simpleboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("/{id}")
    public String boardDetail(@PathVariable Long id,
                              ModelMap modelMap) {
        modelMap.addAttribute("board", boardService.getBoard(id));
        List<Comment> comments = commentService.getComments(id);
        for (Comment comment : comments) {
            System.out.println(comment.getUser().getAlias());
            System.out.println(comment.getUser().getAlias());
            System.out.println(comment.getUser().getAlias());
            System.out.println(comment.getUser().getAlias());
            System.out.println(comment.getUser().getAlias());
            System.out.println(comment.getContent());
            System.out.println(comment.getContent());
            System.out.println(comment.getContent());
            System.out.println(comment.getContent());
            System.out.println(comment.getContent());
            System.out.println("--------------------");
        }
        modelMap.addAttribute("comments", comments);

        return "board/detail";
    }
}
