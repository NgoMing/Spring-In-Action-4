package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegister() throws Exception {

        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {

        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("minhnln", "password", "Ngo", "Minh", "minhnln@gmail.com");
        Spitter saved = new Spitter(24L, "minhnln", "password", "Ngo", "Minh", "minhnln@gmail.com");
        when(mockRepository.save(unsaved))
                .thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Ngo")
                .param("lastName", "Minh")
                .param("username", "minhnln")
                .param("password", "password"))
                .andExpect(redirectedUrl("/spitter/minhnln"));

        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}