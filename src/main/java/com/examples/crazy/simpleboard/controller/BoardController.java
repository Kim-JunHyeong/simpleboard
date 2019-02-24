package com.examples.crazy.simpleboard.controller;

import com.examples.crazy.simpleboard.service.BoardService;
import com.examples.crazy.simpleboard.service.CategoryService;
import com.examples.crazy.simpleboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;
    private final CategoryService categoryService;

    @GetMapping
    public String boardList(ModelMap modelMap,
                           @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {

        modelMap.addAttribute("boards", boardService.getBoards(pageable));
        modelMap.addAttribute("categories", categoryService.getCategories());

        return "board/list";
    }

    @GetMapping("/{id}")
    public String boardDetail(@PathVariable Long id,
                              ModelMap modelMap) {

        modelMap.addAttribute("board", boardService.getBoard(id));
        modelMap.addAttribute("comments", commentService.getComments(id));

        return "board/detail";
    }

    @GetMapping("/writeform")
    public String writeform() {
        return "writeform";
    }
}
