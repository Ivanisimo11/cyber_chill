package com.cyber_chill.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @WithMockUser(roles="ADMIN")
    @Test
    void endpointWhenUserAuthorityThenAuthorized() throws Exception{
        mockMvc.perform(get("/reserve-info"))
                .andExpect(status().isOk());
    }

    @WithMockUser(roles="USER")
    @Test
    void endpointWhenUserAuthorityThenAuthorizedByUser() throws Exception{
        mockMvc.perform(get("/reserve-info"))
                .andExpect(status().isForbidden());
    }

    @WithMockUser
    @Test
    void endpointWhenNotUserAuthorityThenForbidden() throws Exception {
        mockMvc.perform(get("/reserve-info"))
                .andExpect(status().isForbidden());
    }

}
