package softuni.pathfinder.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/users/login")
    private String userLogin() {
        return "login";
    }

}
