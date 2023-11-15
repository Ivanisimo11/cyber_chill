package com.cyber_chill.controller;

import com.cyber_chill.entity.Computer;
import com.cyber_chill.entity.Game;
import com.cyber_chill.entity.Reserve;
import com.cyber_chill.repositories.ComputerRepository;
import com.cyber_chill.service.ComputerService;
import com.cyber_chill.service.ComputerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ComputerController.class)
public class ComputerControllerTest {


    @TestConfiguration
    static class Conf {

        @MockBean
        private ComputerRepository computerRepository;


        @Bean
        ComputerService computerService() {
            return new ComputerServiceImpl(computerRepository);
        }
    }
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser()
    void testGetAllComputers_shouldReturnComputers() throws Exception {
        List<Computer> expectedResult = List.of(
                generateRandomComputer(),
                generateRandomComputer(),
                generateRandomComputer()
        );
        when(computerRepository.findAll()).thenReturn(expectedResult);

        MvcResult mvcResult = mockMvc.perform(get("/computer/"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(), objectMapper.writeValueAsString(expectedResult));
    }

    @Test
    @WithMockUser()
    void testGetComputerByValidID_shouldReturn404() throws Exception {
        when(computerRepository.findById(any())).thenReturn(Optional.empty());

        mockMvc.perform(get("/computer/{id}", 1123L))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    public static Computer generateRandomComputer() {
        Random random = new Random();

        // Generate random values for the fields
        double price = 500 + (1000 - 500) * random.nextDouble(); // Example price range between 500 and 1000
        List<Reserve> reservations = new ArrayList<>();
        List<Game> games = new ArrayList<>();

        // Create and return a new Computer object
        Computer computer = new Computer(price, reservations, games);
        computer.setId(random.nextLong());
        return computer;
    }
}