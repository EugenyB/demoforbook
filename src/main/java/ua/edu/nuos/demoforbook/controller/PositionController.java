package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.edu.nuos.demoforbook.service.PositionService;

@Controller
@AllArgsConstructor
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;

    @PostMapping("/add")
    public String addPosition(@RequestParam("position_title") String title) {
        positionService.add(title);
        return "redirect:/dirs";
    }

    @GetMapping("/delete")
    public String deletePosition(@RequestParam Integer id) {
        positionService.deleteById(id);
        return "redirect:/dirs";
    }

    @PostMapping("/edit_position")
    public String update(@RequestParam("position_id") Integer id, @RequestParam("position_title") String title) {
        positionService.update(id, title);
        return "redirect:/dirs";
    }

}

