package com.sami.springboot.service;

import com.sami.springboot.model.Vehicule;
import com.sami.springboot.repository.VehiculeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    public Vehicule getVehicule(int id) {
        return vehiculeRepository.getVehicule(id);
    }

    public Iterable<Vehicule> getVehicules() {
        return vehiculeRepository.getVehicules();
    }

    public void deleteVehicule(final int id) {
        vehiculeRepository.deleteVehicule(id);
    }

    public Vehicule saveVehicule(Vehicule vehicule) {
        Vehicule saved;

        if(vehicule.getVehicule_id() == null) {
            saved = vehiculeRepository.createVehicule(vehicule);
        } else {
            saved = vehiculeRepository.updateVehicule(vehicule);
        }
        return saved;
    }
}
