package net.openwebinars.springboot.restjwt.controller;

import net.openwebinars.springboot.restjwt.note.controller.NoteController;
import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testcontainers.shaded.org.hamcrest.Matchers.hasSize;
import static org.testcontainers.shaded.org.hamcrest.Matchers.is;

@WebMvcTest(NoteController.class)
public class NoteControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    NoteRepository noteRepository;

    @Test
    void getByAuthorTest() throws Exception{
        List<Note> noteList = List.of(
                Note.builder()
                        .id(1L)
                        .title("Cosas de casa")
                        .content("Me tengo que acordar de dar de comer al gallipato")
                        .author("Roberto")
                        .important(true)
                        .tags(List.of("comida", "gallipato"))
                        .build()

        );
        Mockito.when(noteRepository.findByAuthor("Roberto")).thenReturn(noteList);

        mockMvc.perform(get("/author/{author}").contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].author", is("Roberto")));
    }
}
