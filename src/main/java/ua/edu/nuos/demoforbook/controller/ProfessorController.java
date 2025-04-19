package ua.edu.nuos.demoforbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

    @GetMapping
    public String professors() {
        return "professors";
    }
}

