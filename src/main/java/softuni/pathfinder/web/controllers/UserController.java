package softuni.pathfinder.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.pathfinder.model.dto.UserRegistrationDto;
import softuni.pathfinder.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/login")
    public String userLogin() {
        return "login";
    }

    @GetMapping("/users/register")
    public String register() {
        return "register";

    }

    @PostMapping("/register")
    public String userRegister(@Valid UserRegistrationDto userRegistrationDto,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (!userRegistrationDto.getPassword()
                .equals(userRegistrationDto.getConfirmPassword())) {
            return "register";
        }
        System.out.println(userRegistrationDto);
        userService.registerUser(userRegistrationDto);
        return "redirect:/users/login";
    }
}
