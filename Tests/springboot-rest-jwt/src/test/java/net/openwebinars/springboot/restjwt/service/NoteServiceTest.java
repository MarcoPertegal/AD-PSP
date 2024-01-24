package net.openwebinars.springboot.restjwt.service;

import net.openwebinars.springboot.restjwt.dto.NotesGroupedByTagsDto;
import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import net.openwebinars.springboot.restjwt.note.service.NoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository repository;

    @InjectMocks
    private NoteService noteService;

    @Test
    void testNotesGroupedByTagsDtoList() {
        String author = "Roberto";
        List<String> tags = Arrays.asList("comida", "gallipato");

        Mockito.when(repository.findByAuthor(author)).thenReturn(
                Arrays.asList(
                        Note.builder().tags(Arrays.asList("comida")).build(),
                        Note.builder().tags(Arrays.asList("gallipato")).build()
                )
        );

        List<NotesGroupedByTagsDto> result = noteService.notesGroupedByTagsDtoList(author);

        Assertions.assertEquals(tags.size(), result.size());

    }


}
