package com.chaldu.spirng.web.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        //return "redirect:/app/index";
        //forward NO CAMBIA LA RUTA
        return "forward:/app/index";
        //return "redirect:https://youtics.net";
    }
}
