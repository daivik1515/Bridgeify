package com.jobPortal.Bridgeify.controller;

import com.jobPortal.Bridgeify.entity.Users;
import com.jobPortal.Bridgeify.entity.UsersType;
import com.jobPortal.Bridgeify.services.UsersService;
import com.jobPortal.Bridgeify.services.UsersTypeService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {
    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        List<UsersType> usersTypes=usersTypeService.getAll();
        model.addAttribute("getAllTypes",usersTypes);
        model.addAttribute("user",new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users)
    {
        usersService.addNewUser(users);
        return "dashboard";
    }
}

