package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.edu.nuos.demoforbook.data.Position;
import ua.edu.nuos.demoforbook.service.CityService;
import ua.edu.nuos.demoforbook.service.MajorService;
import ua.edu.nuos.demoforbook.service.PositionService;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {

    private CityService cityService;
    private MajorService majorService;
    private PositionService positionService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/dirs")
    public String dirs(Model model) {
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("majors", majorService.findAll());
        model.addAttribute("positions", positionService.findAll());
        return "directories";
    }
}

