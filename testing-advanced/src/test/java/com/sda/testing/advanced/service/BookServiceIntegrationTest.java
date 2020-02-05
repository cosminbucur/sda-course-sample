package com.sda.testing.advanced.service;

import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.dto.BookResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookServiceIntegrationTest {

    @Autowired
    private BookService bookService;

    @Test
    void givenBookRequest_whenSave_thenReturnBookResponse() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("game of thrones");
        request.setAuthor("george martin");
        request.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setId(1L);
        expected.setTitle("game of thrones");
        expected.setAuthor("george martin");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        // when
        BookResponse actual = bookService.save(request);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenExistingBook_whenSave_thenThrowException() {
        // given
        // setup initial db state
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("game of thrones");
        bookRequest.setAuthor("george martin");
        bookRequest.setPublished(LocalDate.of(2000, 6, 30));

        bookService.save(bookRequest);

        // then
        Assertions.assertThrows(RuntimeException.class,
                // when
                () -> bookService.save(bookRequest));
    }

    @Test
    void findAll() {
    }

    @Test
    void givenValidId_whenFindById_thenReturnBookResponse() {
        // given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("game of thrones");
        bookRequest.setAuthor("george martin");
        bookRequest.setPublished(LocalDate.of(2000, 6, 30));

        bookService.save(bookRequest);

        // when
        BookResponse actual = bookService.findById(1L);

        assertThat(actual.getTitle()).isEqualTo(bookRequest.getTitle());
    }

    @Test
    void givenInvalidId_whenFindById_thenThrowException() {
        Assertions.assertThrows(RuntimeException.class,
                () -> bookService.findById(1L));
    }

    @Test
    void findByAuthor() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void partialUpdate() {
    }
}