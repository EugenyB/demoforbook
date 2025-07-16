package ua.edu.nuos.demoforbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.edu.nuos.demoforbook.data.City;
import ua.edu.nuos.demoforbook.service.CityService;

@Controller
@AllArgsConstructor
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @PostMapping("/add")
    public String addCity(@RequestParam("city_name") String name) {
        cityService.add(new City(name));
        return "redirect:/dirs";
    }

    @GetMapping("/delete")
    public String deleteCity(@RequestParam Integer id) {
        cityService.deleteById(id);
        return "redirect:/dirs";
    }

    @PutMapping("/edit_city")
    public String editCity(@RequestParam("city_id") Integer id, @RequestParam("city_name") String name) {
        cityService.updateCity(id, name);
        return "redirect:/dirs";
    }
}

