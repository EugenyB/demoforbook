package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.nuos.demoforbook.data.Subject;
import ua.edu.nuos.demoforbook.service.SubjectService;

@Controller
@RequestMapping("/subjects")
@AllArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public String subjects(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "subjects";
    }

    @PostMapping("/add")
    public String addSubject(
            @RequestParam("subject_title") String title,
            @RequestParam("subject_description") String description,
            @RequestParam("subject_semester") Integer semester,
            @RequestParam("subject_duration") Integer duration) {

        subjectService.add(title, description, semester, duration);
        return "redirect:/subjects";
    }

    @PostMapping("/edit")
    public String editSubject(
            @RequestParam("subject_id") Integer subjectId,
            @RequestParam("subject_title") String title,
            @RequestParam("subject_description") String description,
            @RequestParam("subject_semester") Integer semester,
            @RequestParam("subject_duration") Integer duration) {

            subjectService.update(subjectId, title, description, semester, duration);
        return "redirect:/subjects";
    }
}

