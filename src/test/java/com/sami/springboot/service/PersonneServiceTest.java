package com.sami.springboot.service;

import com.sami.springboot.model.Personne;
import com.sami.springboot.repository.PersonneRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonneServiceTest {

    @Mock
    private PersonneRepository personneRepository;

    @InjectMocks
    private PersonneService personneService;

    @Test
    public void testGetPersonne_shouldReturnPersonne() {
        // Arrange
        Personne mockPersonne = new Personne();
        mockPersonne.setPersonne_id(1);
        mockPersonne.setPersonne_nom("Jean Dupont");
        mockPersonne.setPersonne_mail("jean.dupont@example.com");

        when(personneRepository.getPersonne(1)).thenReturn(mockPersonne);

        // Act
        Personne result = personneService.getPersonne(1);

        // Assert
        assertNotNull(result);
        assertEquals("Jean Dupont", result.getPersonne_nom());
        assertEquals("jean.dupont@example.com", result.getPersonne_mail());
    }

    @Test
    public void testSavePersonne_shouldCallCreatePersonne_whenIdIsNull() {
        // Arrange
        Personne newPersonne = new Personne();
        newPersonne.setPersonne_nom("Nouvelle");
        newPersonne.setPersonne_mail("nouvelle@ex.com");

        Personne saved = new Personne();
        saved.setPersonne_id(5);
        saved.setPersonne_nom("Nouvelle");
        saved.setPersonne_mail("nouvelle@ex.com");

        when(personneRepository.createPersonne(any(Personne.class))).thenReturn(saved);

        // Act
        Personne result = personneService.savePersonne(newPersonne);

        // Assert
        assertNotNull(result);
        assertEquals(Optional.of(5), result.getPersonne_id());
        verify(personneRepository).createPersonne(newPersonne);
    }

}
