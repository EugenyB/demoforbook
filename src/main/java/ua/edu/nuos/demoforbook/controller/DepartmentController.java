package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nuos.demoforbook.data.Department;
import ua.edu.nuos.demoforbook.service.DepartmentService;
import ua.edu.nuos.demoforbook.service.PositionService;
import ua.edu.nuos.demoforbook.service.ProfessorService;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final ProfessorService professorService;
    private final PositionService positionService;

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

    @PostMapping("/add")
    public String addDepartment(@RequestParam("dept_name") String name) {
        departmentService.addDepartment(name);
        return "redirect:/departments";
    }

    @GetMapping("/professors")
    public String professors(@RequestParam Integer id, Model model) {
        Optional<Department> optDepartment = departmentService.findById(id);
        if (optDepartment.isPresent()) {
            Department department = optDepartment.get();
            model.addAttribute("department", department);
            model.addAttribute("professors", department.getProfessors());
            model.addAttribute("departments", departmentService.findAll());
            model.addAttribute("positions", positionService.findAll());
            return "professors";
        } else {
            return "redirect:/departments";
        }
    }
}

