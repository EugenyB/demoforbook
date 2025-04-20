package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nuos.demoforbook.service.CityService;
import ua.edu.nuos.demoforbook.service.GroupService;
import ua.edu.nuos.demoforbook.service.StudentService;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final CityService cityService;
    private final GroupService groupService;

    @GetMapping
    public String students(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("groups", groupService.findAll());
        return "students";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam("flag") Integer flag,
            @RequestParam("student_first_name") String firstName,
            @RequestParam("student_last_name") String lastName,
            @RequestParam("student_birthday") String birthdayStr,
            @RequestParam("city_id") Integer cityId,
            @RequestParam("student_address") String address,
            @RequestParam("group_id") Integer groupId) {
        studentService.addStudent(firstName, lastName, birthdayStr, cityId, address, groupId);
        if (flag==1) {
            return "redirect:/groups/students?id=" + groupId;
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam("student_id") Integer id,
            @RequestParam("flag") Integer flag,
            @RequestParam("student_first_name") String firstName,
            @RequestParam("student_last_name") String lastName,
            @RequestParam("student_birthday") String birthdayStr,
            @RequestParam("city_id") Integer cityId,
            @RequestParam("student_address") String address,
            @RequestParam("group_id") Integer groupId) {
        studentService.updateStudent(id, firstName, lastName, birthdayStr, cityId, address, groupId);
        if (flag==1) {
            return "redirect:/groups/students?id=" + groupId;
        } else {
            return "redirect:/students";
        }
    }

}

