package com.sami.springboot.repository;

import com.sami.config.CustomProperties;
import com.sami.springboot.model.Personne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class PersonneRepository {
    @Autowired
    private CustomProperties props;

    /**
     * Get all Personne
     * @return An iterable of all Personnes
     */
    public Iterable<Personne> getPersonnes() {
        String baseApiUrl = props.getApiUrl();
        String getPersonnesUrl = baseApiUrl + "/personnes";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Personne>> response = restTemplate.exchange(
            getPersonnesUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<>() {}
        );

        log.debug("Get personnes:" + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Get a personne by the id
     * @param id The id of the Personne
     * @return The personne which matches the id
     */
    public Personne getPersonne(int id) {
        String baseApiUrl = props.getApiUrl();
        String getPersonneUrl = baseApiUrl + "/personne/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Personne> response = restTemplate.exchange(
                getPersonneUrl,
                HttpMethod.GET,
                null,
                Personne.class
        );

        log.debug("Get personne: " + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Add a new Personne
     * @param e A new personne (without an id)
     * @return The Personne full filled (with an id)
     */
    public Personne createPersonne(Personne e) {
        String baseApiUrl = props.getApiUrl();
        String createPersonneUrl = baseApiUrl + "/personne";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Personne> request = new HttpEntity<>(e);
        ResponseEntity<Personne> response = restTemplate.exchange(
                createPersonneUrl,
                HttpMethod.POST,
                request,
                Personne.class
        );
        log.debug("Create personne: " + response.getStatusCode());
        return response.getBody();
    }

    /**
     * Update a Personne - using the PUT HTTP Method.
     * @param e Existing personnes to update
     */
    public Personne updatePersonne(Personne e) {
        String baseApiUrl = props.getApiUrl();
        String updatePersonneUrl = baseApiUrl + "/personne/" + e.getPersonne_id();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Personne> request = new HttpEntity<>(e);
        ResponseEntity<Personne> response = restTemplate.exchange(
                updatePersonneUrl,
                HttpMethod.PUT,
                request,
                Personne.class
        );
        log.debug("Update personne: " + response.getStatusCode());
        return response.getBody();
    }
    /**
     * Delete a Personne using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The Personne to delete
     */
    public void deletePersonne(int id) {
        String baseApiUrl = props.getApiUrl();
        String deletePersonneUrl = baseApiUrl + "/personne/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deletePersonneUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );
        log.debug("Delete personne: " + response.getStatusCode());
    }




















}
