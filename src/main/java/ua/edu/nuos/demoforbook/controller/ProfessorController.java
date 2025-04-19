package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nuos.demoforbook.service.DepartmentService;
import ua.edu.nuos.demoforbook.service.PositionService;
import ua.edu.nuos.demoforbook.service.ProfessorService;

@Controller
@AllArgsConstructor
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    @GetMapping
    public String professors(Model model) {
        model.addAttribute("professors", professorService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("positions", positionService.findAll());
        return "professors";
    }

    @PostMapping("/add")
    public String addProfessor(
            @RequestParam("prof_first_name") String firstName,
            @RequestParam("prof_last_name") String lastName,
            @RequestParam("prof_degree") String degree,
            @RequestParam("dept_id") Integer departmentId,
            @RequestParam("position_id") Integer positionId) {

            professorService.addProfessor(firstName, lastName, degree, departmentId, positionId);
        return "redirect:/departments/professors?id="+departmentId;
    }

    @PostMapping("/edit")
    public String editProfessor(
            @RequestParam("prof_id") Integer id,
            @RequestParam("prof_first_name") String firstName,
            @RequestParam("prof_last_name") String lastName,
            @RequestParam("prof_degree") String degree,
            @RequestParam("dept_id") Integer departmentId,
            @RequestParam("position_id") Integer positionId) {
        professorService.update(id, firstName, lastName, degree, departmentId, positionId);
        return "redirect:/departments/professors?id="+departmentId;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, @RequestParam Integer did, @RequestParam(required = false) Integer dept) {
        professorService.deleteById(id);
        if (dept == null) {
            return "redirect:/professors";
        }
        return "redirect:/departments/professors?id="+did;
    }
}

