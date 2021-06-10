package com.example.CRUD.CRUDUFRO.driver;

import com.example.CRUD.CRUDUFRO.modelo.Persona;
import com.example.CRUD.CRUDUFRO.services.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DriverPersona {

    @Autowired
    private ServicioPersona servicioPersona;

    @RequestMapping("/")
    public String index(Model modelo) {
        modelo.addAttribute("lista", servicioPersona.getAll());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String MostrarGuardado(@PathVariable("id") int id, Model modelo) {
        if( id != 0 ) {
            modelo.addAttribute("persona", servicioPersona.obtener(id));
        } else {
            modelo.addAttribute("persona", new Persona());
        }
        return "form";
    }

    @PostMapping("/save")
    public String guardar(Persona persona, Model modelo) {
        servicioPersona.guardar(persona);

        return "redirect:/";
    }

    @GetMapping("/new")
    public String agregar(Model modelo) {
        modelo.addAttribute("persona", new Persona());
        return "form";
    }

    @GetMapping("delete/{id}")
    public String eliminar(@PathVariable("id") int id, Model modelo) {
        servicioPersona.eliminar(id);
        return "redirect:/";
    }

}
