package com.jobPortal.Bridgeify.controller;

import com.jobPortal.Bridgeify.entity.Users;
import com.jobPortal.Bridgeify.entity.UsersType;
import com.jobPortal.Bridgeify.services.UsersTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {
    private final UsersTypeService usersTypeService;

    public UsersController(UsersTypeService usersTypeService) {
        this.usersTypeService = usersTypeService;
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        List<UsersType> usersTypes=usersTypeService.getAll();
        model.addAttribute("getAllTypes",usersTypes);
        model.addAttribute("user",new Users());
        return "register";
    }
}

