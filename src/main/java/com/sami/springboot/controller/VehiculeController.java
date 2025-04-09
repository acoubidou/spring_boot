package com.sami.springboot.controller;

import com.sami.springboot.model.Vehicule;
import com.sami.springboot.service.VehiculeService;
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
public class VehiculeController {

    @Autowired
    private VehiculeService service;

    @PostMapping("/saveVehicule")
    public ModelAndView saveVehicule(@ModelAttribute Vehicule vehicule) {
        if (vehicule.getVehicule_id() != null) {
            Vehicule current = service.getVehicule(vehicule.getVehicule_id());
            if(current != null) {
                current.setVehicule_marque(vehicule.getVehicule_marque());
                current.setVehicule_modele(vehicule.getVehicule_modele());
                service.saveVehicule(current);
            }
        } else {
            service.saveVehicule(vehicule);
        }
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/deleteVehicule/{id}")
    public ModelAndView deleteVehicule(@PathVariable("id") final int id) {
        service.deleteVehicule(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/vehicule-liste")
    public String vehiculeListe(Model model) {
        model.addAttribute("pageTitle", "Vehicule - Liste");
        Iterable<Vehicule> listVehicules = service.getVehicules();
        model.addAttribute("vehicules", listVehicules);
        return "vehicule/vehicule_liste";
    }

    @GetMapping("/vehicule-creation")
    public String vehiculeCreate(Model model) {
        model.addAttribute("pageTitle", "Vehicule - Creation");
        model.addAttribute("vehicule", new Vehicule());
        return "vehicule/vehicule_save";
    }

    @GetMapping("/vehicule-modification/{id}")
    public String vehiculeModif(@PathVariable("id") final int id, Model model) {
        model.addAttribute("pageTitle", "Vehicule - Modification");
        Vehicule vehicule = service.getVehicule(id);
        model.addAttribute("vehicule", vehicule);
        return "vehicule/vehicule_save";
    }
}
