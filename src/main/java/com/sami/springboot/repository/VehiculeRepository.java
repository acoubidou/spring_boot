package com.sami.springboot.repository;

import com.sami.config.CustomProperties;
import com.sami.springboot.model.Vehicule;
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
public class VehiculeRepository {
    @Autowired
    private CustomProperties props;

    /**
     * Get all Vehicule
     * @return An iterable of all Vehicules
     */
    public Iterable<Vehicule> getVehicules() {
        String baseApiUrl = props.getApiUrl();
        String getVehiculesUrl = baseApiUrl + "/vehicules";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Vehicule>> response = restTemplate.exchange(
                getVehiculesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        log.debug("Get vehicules:" + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Get a vehicule by the id
     * @param id The id of the Vehicule
     * @return The vehicule which matches the id
     */
    public Vehicule getVehicule(int id) {
        String baseApiUrl = props.getApiUrl();
        String getVehiculeUrl = baseApiUrl + "/vehicule/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Vehicule> response = restTemplate.exchange(
                getVehiculeUrl,
                HttpMethod.GET,
                null,
                Vehicule.class
        );

        log.debug("Get vehicule:" + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Add a new Vehicule
     * @param e A new vehicule (without an id)
     * @return The Vehicule full filled (with and id)
     */
    public Vehicule createVehicule(Vehicule e) {
        String baseApiUrl = props.getApiUrl();
        String createVehiculeUrl = baseApiUrl + "/vehicule";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Vehicule> request = new HttpEntity<>(e);
        ResponseEntity<Vehicule> response = restTemplate.exchange(
                createVehiculeUrl,
                HttpMethod.POST,
                request,
                Vehicule.class
        );
        log.debug("Create vehicule:" + response.getStatusCode());
        return response.getBody();
    }

    /**
     * Update a Vehicule - using the PUT HTTP Method
     * @param e Existing vehicules to update
     */
    public Vehicule updateVehicule(Vehicule e) {
        String baseApiUrl = props.getApiUrl();
        String updateVehiculeUrl = baseApiUrl + "/vehicule/" + e.getVehicule_id();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Vehicule> request = new HttpEntity<>(e);
        ResponseEntity<Vehicule> response = restTemplate.exchange(
                updateVehiculeUrl,
                HttpMethod.PUT,
                request,
                Vehicule.class
        );
        log.debug("Update vehicule:" + response.getStatusCode());
        return response.getBody();
    }
    /**
     * Delete a Vehicule using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param id The vehicule to delete
     */
    public void deleteVehicule(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteVehiculeUrl = baseApiUrl + "/vehicule/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteVehiculeUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );
        log.debug("Delete vehicule:" + response.getStatusCode());
    }




















}
