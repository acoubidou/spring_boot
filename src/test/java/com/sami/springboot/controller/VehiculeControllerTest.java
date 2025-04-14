package com.sami.springboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class VehiculeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getVehiculeTest() throws Exception {
        mockMvc.perform(get("/vehicule-liste"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("vehicule/vehicule_liste"))
                .andExpect(MockMvcResultMatchers.content().string(containsString("vehicule")));
    }

}