package com.menken.trials.data.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AngularController {
    @RequestMapping(value = "/{path:[^.]*}")
    public String redirect() {
        return "forward:/index.html";
    }
}