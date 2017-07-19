package com.itransition.controller;

import com.itransition.converter.UserConverter;
import com.itransition.dto.UserDTO;
import com.itransition.entity.User;
import com.itransition.security.details.CustomUserDetailsProvider;
import com.itransition.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/info")
public class RestFullDataController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(Model model) {
        Long id = CustomUserDetailsProvider.getUserDetails().getId();
        User user = userService.findOne(id);
        model.addAttribute("username",user.getName());
        ModelAndView modelAndView = new ModelAndView("paint");
        return modelAndView;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloGET() {
        String name = CustomUserDetailsProvider.getUserDetails().getUsername();
        return "Hello, " + name + "!";
    }
}
