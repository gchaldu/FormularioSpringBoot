package com.chaldu.spirng.web.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariableRutaController {
    
    @GetMapping("/string/{texto}")
    public String getString(@PathVariable String texto, Model model) {
        model.addAttribute("resultado", "El texto enviado a la ruta es: " + texto);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String getString(@PathVariable String texto, @PathVariable Integer numero, Model model) {
        model.addAttribute("resultado", "El texto enviado a la ruta es: " + texto + " El numero enviado a la ruta es: " + numero);
        return "variables/ver";
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("textoEnviar", "Texto enviado con model");
        model.addAttribute("numeroEnviar", 20);
        return "variables/index";
    }
}
