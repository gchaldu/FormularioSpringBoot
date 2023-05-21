package com.chaldu.spirng.web.appweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chaldu.spirng.web.appweb.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {

    /*RETORNA EL NOMBRE DE LA LISTA */
    //@RequestMapping(value = "/index", method = RequestMethod.GET)
    @GetMapping(value = {"/index", "/"})
    //public String index(Model model)
    public String index(ModelMap model)
    {
        model.addAttribute("titulo", "Facundo!!!!");
        return "index";
    }
    @RequestMapping(value = "/perfil")
    public String perfil(Model model)
    {
        Usuario usuario = new Usuario();
        usuario.setApellido("Chaldu");
        usuario.setNombre("Gabriel");
        usuario.setEmail("gabriel@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del Usuario");
        return "perfil";
    }

    @GetMapping(value = {"/listar"})
    public String listar(ModelMap model)
    {
        model.addAttribute("titulo", "Listado de usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> listUsuarios()
    {
        List<Usuario> list = new ArrayList<>();
        list.add(new Usuario("Caro", "Archu", "caro@gmail.com"));
        list.add(new Usuario("Caro2", "Archu2", "caro2@gmail.com"));
        list.add(new Usuario("Caro3", "Archu3", "caro3@gmail.com"));
        list.add(new Usuario("Caro4", "Archu4", "caro4@gmail.com"));
        return list;
    }
    
}
