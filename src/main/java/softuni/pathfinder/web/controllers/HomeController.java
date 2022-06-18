package softuni.pathfinder.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    private String home() {
        return "index";
    }

    @GetMapping("/about")
    private String about() {
        return "about";
    }
}
