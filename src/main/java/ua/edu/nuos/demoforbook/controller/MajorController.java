package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nuos.demoforbook.service.MajorService;

@Controller
@AllArgsConstructor
@RequestMapping("/majors")
public class MajorController {
    private final MajorService majorService;

    @RequestMapping("/delete")
    public String deleteMajor(@RequestParam Integer id) {
        majorService.deleteById(id);
        return "redirect:/dirs";
    }

    @PostMapping("/add")
    public String addMajor(@RequestParam("major_title") String title, @RequestParam("major_code") String code) {
        majorService.add(title, code);
        return "redirect:/dirs";
    }

    @PostMapping("/edit_major")
    public String update(@RequestParam("major_id") Integer id, @RequestParam("major_title") String title, @RequestParam("major_code") String code) {
        majorService.update(id, title, code);
        return "redirect:/dirs";
    }
}

