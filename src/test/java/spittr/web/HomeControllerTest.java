package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void homePage() throws Exception {

        HomeController controller = new HomeController();

        // Setup MockMvc
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/"))               // Perform GET "/"
                .andExpect(view().name("home"));// Expect Home view
    }

}