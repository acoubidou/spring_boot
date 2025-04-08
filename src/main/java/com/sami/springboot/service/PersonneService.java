package com.sami.springboot.service;

import com.sami.springboot.model.Personne;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sami.springboot.repository.PersonneRepository;

@Data
@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    public Personne getPersonne(int id) {
        return personneRepository.getPersonne(id);
    }

    public Iterable<Personne> getPersonnes() {
        return personneRepository.getPersonnes();
    }

    public void deletePersonne(final int id) {
        personneRepository.deletePersonne(id);
    }

    public Personne savePersonne(Personne personne) {
        Personne saved;

        if(personne.getPersonne_id() == null) {
            saved = personneRepository.createPersonne(personne);
        } else {
            saved = personneRepository.updatePersonne(personne);
        }

        return saved;
    }
}
