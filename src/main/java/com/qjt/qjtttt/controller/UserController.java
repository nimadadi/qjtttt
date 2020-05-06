package com.qjt.qjtttt.controller;

import com.qjt.qjtttt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/in")
    public String index(Model model){

        logger.info("index");
        model.addAttribute("user1",userService.findById(1).toString());

        model.addAttribute("user2",userService.findById1(1).toString());

        return "index";
    }

}
