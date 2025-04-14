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
public class PersonneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPersonneTest() throws Exception {
        mockMvc.perform(get("/personne-liste"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("personne/personne_liste"))
                .andExpect(MockMvcResultMatchers.content().string(containsString("personne")));
    }

}
