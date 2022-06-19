package softuni.pathfinder.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.pathfinder.model.dto.CurrentUser;
import softuni.pathfinder.model.dto.UserLoginDto;
import softuni.pathfinder.model.dto.UserRegistrationDto;
import softuni.pathfinder.model.entity.User;
import softuni.pathfinder.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto flashRegistrationForm() {
        return new UserRegistrationDto();
    }

    @GetMapping("/users/login")
    public String userLogin() {
        return "login";
    }

    @GetMapping("/users/register")
    public String register() {
        return "register";

    }

    @PostMapping("/users/register")
    public String userRegister(@Valid UserRegistrationDto userRegistrationDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto",
                            bindingResult);
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            return "redirect:/users/register";
        }
        if (!userRegistrationDto.getPassword()
                .equals(userRegistrationDto.getConfirmPassword())) {
            return "redirect:/users/register";
        }
        userService.registerUser(userRegistrationDto);
        return "redirect:/users/login";
    }

    @PostMapping("users/login")
    public String userLogin(UserLoginDto userLoginDto) {
        User user = userService.findUserByUsername(userLoginDto.getUsername());
        CurrentUser currentUser = CurrentUser.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
        return "redirect:/";
    }
}
