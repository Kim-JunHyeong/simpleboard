package com.examples.crazy.simpleboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/boards"})
    public String mainPage() {
        return "mainPage";
    }
}
