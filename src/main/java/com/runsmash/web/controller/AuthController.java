package com.runsmash.web.controller;

import com.runsmash.web.dto.RegistrationDto;
import com.runsmash.web.models.UserEntity;
import com.runsmash.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController
{
    private UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new RegistrationDto());
        return "register";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user, Model model, BindingResult result) {
        UserEntity existingUser;
        existingUser = userService.findEmail(user.getEmail());
        if (existingUser != null && existingUser.getEmail()!=null && !existingUser.getEmail().isEmpty())
        {
            result.rejectValue("email","Email is already in use");
            return "redirect:/register?fail";
        }
        UserEntity euUsername = userService.findUsername(user.getUsername());

        if (euUsername != null && euUsername.getUsername()!=null && !euUsername.getUsername().isEmpty())
        {
            result.rejectValue("username","username is already in use");
            return "redirect:/register?fail";
        }

        if(result.hasErrors()) {
            model.addAttribute("errors", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/clubs?success";
    }


}
