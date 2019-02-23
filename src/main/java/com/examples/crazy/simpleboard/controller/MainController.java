package com.examples.crazy.simpleboard.controller;

import com.examples.crazy.simpleboard.service.BoardService;
import com.examples.crazy.simpleboard.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BoardService boardService;
    private final CategoryService categoryService;

    @GetMapping(value = {"/", "/boards"})
    public String mainPage(ModelMap modelMap,
                           @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {

        modelMap.addAttribute("boards", boardService.getBoards(pageable));
        modelMap.addAttribute("categories", categoryService.getCategories());

        return "boards";
    }
}
