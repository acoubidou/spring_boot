package com.sami.springboot.controller;

import com.sami.springboot.model.Personne;
import com.sami.springboot.service.PersonneService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Data
@Controller
public class PersonneController {

    @Autowired
    private PersonneService service;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Personne> listPersonnes = service.getPersonnes();
        model.addAttribute("personnes", listPersonnes);
        model.addAttribute("personne", new Personne());
        return "index";
    }

    @GetMapping("/deletePersonne/{id}")
    public ModelAndView deletePersonne(@PathVariable("id") final int id) {
        service.deletePersonne(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/savePersonne")
    public ModelAndView savePersonne(@ModelAttribute Personne personne) {
        if (personne.getPersonne_id() != null) {
            Personne current = service.getPersonne(personne.getPersonne_id());
            if(current != null) {
                current.setPersonne_nom(personne.getPersonne_nom());
                current.setPersonne_mail(personne.getPersonne_mail());
                service.savePersonne(current);
            }
        } else {
            service.savePersonne(personne);
        }
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/hmst")
    public String hmst() {
        return "hmst";
    }
}
