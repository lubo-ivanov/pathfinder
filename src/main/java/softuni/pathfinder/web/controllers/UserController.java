package softuni.pathfinder.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.pathfinder.model.service.UserServiceModel;
import softuni.pathfinder.model.view.UserViewModel;
import softuni.pathfinder.util.CurrentUser;
import softuni.pathfinder.model.dto.UserLoginDto;
import softuni.pathfinder.model.dto.UserRegistrationDto;
import softuni.pathfinder.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto flashRegistrationForm() {
        return new UserRegistrationDto();
    }

    @ModelAttribute("userLoginDto")
    public UserLoginDto userLoginDto() {
        return new UserLoginDto();
    }

    @GetMapping("/login")
    public String userLogin(Model model) {
        model.addAttribute("doesExist", true);
        return "login";
    }

    @PostMapping("/login")
    public String userLogin(@Valid UserLoginDto userLoginDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto",
                            bindingResult);
            return "redirect:/login";
        }
        UserServiceModel userServiceModel = userService
                .findUserByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
        if (userServiceModel == null) {
            redirectAttributes
                    .addFlashAttribute("doesExist", false)
                    .addFlashAttribute("userLoginDto", userLoginDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto",
                            bindingResult);
            return "redirect:/login";
        }
        loginUser(userServiceModel);
        return "redirect:/";
    }


    @GetMapping("/logout")
    private String logoutUser() {
        currentUser.setId(null);
        currentUser.setUsername(null);
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    private String profile(@PathVariable("id") Long id, Model model) {
model.addAttribute("userProfile", modelMapper.map(userService.findById(id), UserViewModel.class));
        return "profile";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String userRegister(@Valid UserRegistrationDto userRegistrationDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userRegistrationDto", userRegistrationDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto",
                            bindingResult);
            return "redirect:/register";
        }
        if (!userRegistrationDto.getPassword()
                .equals(userRegistrationDto.getConfirmPassword())) {
            return "redirect:/register";
        }
        userService.registerUser(modelMapper.map(userRegistrationDto, UserServiceModel.class));
        return "redirect:/users/login";
    }


    private void loginUser(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId());
        currentUser.setUsername(userServiceModel.getUsername());
    }

}
