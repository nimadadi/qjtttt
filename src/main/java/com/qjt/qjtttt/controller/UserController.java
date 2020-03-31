package com.qjt.qjtttt.controller;

import com.qjt.qjtttt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger _logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/in")
    public String index(Model model){

        model.addAttribute("user1",userService.findById(1).toString());

        model.addAttribute("user2",userService.findById1(1).toString());

        return "index";
    }

}
