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

//    @PreAuthorize("isAuthenticated()")
    @Test
    @WithMockUser(authorities="LOX")
    public void testUserEndpointWithUserRole() throws Exception {
        mockMvc.perform(get("/computer/"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void testAdminEndpoint() throws Exception {
        mockMvc.perform(get("/reserve-info/page"))
                .andExpect(status().isOk());
    }

//    @Test
//    @WithMockUser(username = "manager", roles = "MANAGER")
//    public void testManagerEndpointWithManagerRole() throws Exception {
//        mockMvc.perform(get("/your-manager-protected-endpoint"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Hello, Manager!"));
//    }

    @WithMockUser(authorities="ADMIN")
    @Test
    void endpointWhenUserAuthorityThenAuthorized() throws Exception{
        mockMvc.perform(get("/reserve-info"))
                .andExpect(status().isOk());
    }

    @WithMockUser(authorities="USER")
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

    @Test
    void anyWhenUnauthenticatedThenUnauthorized() throws Exception{
        mockMvc.perform(get("/any"))
                .andExpect(status().isUnauthorized());
    }
}
