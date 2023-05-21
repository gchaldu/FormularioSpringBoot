package com.chaldu.spirng.web.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping(value = "/")
    public String index()
    {
        return "params/index";
    }
    
    @GetMapping(value = "/string")
    public String params( @RequestParam(name="texto", defaultValue = "No hay nada que mostrar") 
                        String texto, Model model)
    {
        model.addAttribute("resultado", "El texto/parametro enviado es: " + texto);
        return "params/ver";
    }

    @GetMapping(value = "/mix-params")
    public String params(@RequestParam String saludo, 
                            @RequestParam Integer numero, Model model)
    {
        model.addAttribute("resultado", "El texto y el numero enviado son/parametro enviado es: " + numero + "Saludo = " + saludo);
        return "params/ver";
    }

    @GetMapping(value = "/mix-params-http")
    public String params(HttpServletRequest request, Model model)
    {
        String saludo = null;
        Integer numero=null;
        String error=null;
        try{
            saludo = request.getParameter("saludo");
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch(Exception e)
        {
            error = e.getMessage();
        }
        model.addAttribute("error", error);
        model.addAttribute("resultado", "El texto y el numero enviado son/parametro enviado es: " + numero + "\nSaludo = " + saludo);
        return "params/ver";
    }
}
