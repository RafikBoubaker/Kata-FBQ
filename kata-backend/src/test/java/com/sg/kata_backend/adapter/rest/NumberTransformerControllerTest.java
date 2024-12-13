package com.sg.kata_backend.adapter.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class NumberTransformerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValidNumberTransformation() throws Exception {

        mockMvc.perform(get("/api/transform/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOO"));

        mockMvc.perform(get("/api/transform/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("BAR"));

        mockMvc.perform(get("/api/transform/15"))
                .andExpect(status().isOk())
                .andExpect(content().string("FOOBAR"));

        mockMvc.perform(get("/api/transform/7"))
                .andExpect(status().isOk())
                .andExpect(content().string("QUIX"));
    }

    @Test
    void testInvalidNumberRangeInput() throws Exception {

        mockMvc.perform(get("/api/transform/-1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Veuillez entrer un nombre entre 0 et 100."));

        mockMvc.perform(get("/api/transform/101"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Veuillez entrer un nombre entre 0 et 100."));
    }


    @Test
    void testDefaultCase() throws Exception {
        mockMvc.perform(get("/api/transform/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));

        mockMvc.perform(get("/api/transform/0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
}