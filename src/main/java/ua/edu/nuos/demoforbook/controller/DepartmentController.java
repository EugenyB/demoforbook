package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nuos.demoforbook.service.DepartmentService;
import ua.edu.nuos.demoforbook.service.ProfessorService;

@Controller
@AllArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final ProfessorService professorService;

    @GetMapping
    public String departments(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("professors", professorService.findWithoutDepartments());
        return "departments";
    }

    @PostMapping("/set_head")
    public String setHead(@RequestParam Integer did, @RequestParam Integer hid) {
        departmentService.setHead(did, hid);
        return "redirect:/departments";
    }
}

