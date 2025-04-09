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
    @GetMapping("/deletePersonne/{id}")
    public ModelAndView deletePersonne(@PathVariable("id") final int id) {
        service.deletePersonne(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/personne-liste")
    public String personneListe(Model model) {
        model.addAttribute("pageTitle", "Personne - Liste");
        Iterable<Personne> listPersonnes = service.getPersonnes();
        model.addAttribute("personnes", listPersonnes);
        return "personne/personne_liste";
    }

    @GetMapping("/personne-creation")
    public String personneCreate(Model model) {
        model.addAttribute("pageTitle", "Personne - Creation");
        model.addAttribute("personne", new Personne());
        return "personne/personne_save";
    }

    @GetMapping("/personne-modification/{id}")
    public String personneModif(@PathVariable("id") int id, Model model) {
        model.addAttribute("pageTitle", "Personne - Modification");
        Personne personne = service.getPersonne(id);
        model.addAttribute("personne", personne);
        return "personne/personne_save";
    }

}
