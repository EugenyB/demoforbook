package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nuos.demoforbook.data.AcademGroup;
import ua.edu.nuos.demoforbook.service.DepartmentService;
import ua.edu.nuos.demoforbook.service.GroupService;
import ua.edu.nuos.demoforbook.service.MajorService;
import ua.edu.nuos.demoforbook.service.ProfessorService;

import java.util.Optional;

@Controller
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final MajorService majorService;
    private final DepartmentService departmentService;
    private final ProfessorService professorService;

    @GetMapping
    public String groups(Model model) {
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("majors", majorService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("professors", professorService.findAll());
        return "groups";
    }

    @GetMapping("/students")
    public String students(@RequestParam Integer id, Model model) {
        Optional<AcademGroup> optGroup = groupService.findById(id);
        if (optGroup.isPresent()) {
            model.addAttribute("group", optGroup.get());
            model.addAttribute("students", optGroup.get().getStudents());
            return "students";
        } else {
            return "redirect:/groups";
        }
    }

    @PostMapping("/add")
    public String addGroup(@RequestParam("group_name") String name, @RequestParam("major_id") Integer majorId, @RequestParam("dept_id") Integer deptId, @RequestParam("prof_id") Integer profId) {
        groupService.addGroup(name, majorId, deptId, profId);
        return "redirect:/groups";
    }

    @GetMapping("/delete")
    public String deleteGroup(@RequestParam Integer id) {
        groupService.deleteById(id);
        return "redirect:/groups";
    }
// group_id=11&group_name=1521&major_id=1&dept_id=1&prof_id=1
    @PostMapping("/edit")
    public String editGroup(
            @RequestParam("group_id") Integer id,
            @RequestParam("group_name") String name,
            @RequestParam("major_id") Integer majorId,
            @RequestParam("dept_id") Integer deptId,
            @RequestParam("prof_id") Integer profId) {
        groupService.update(id,name,majorId,deptId,profId);
        return "redirect:/groups";
    }
}

