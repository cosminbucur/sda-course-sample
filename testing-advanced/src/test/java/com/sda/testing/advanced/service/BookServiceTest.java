package com.sda.testing.advanced.service;

import com.sda.testing.advanced.dto.BookMapper;
import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.dto.BookResponse;
import com.sda.testing.advanced.model.Book;
import com.sda.testing.advanced.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookService bookService;

    @Test
    void givenBookRequest_whenSave_thenReturnBookResponse() {
        // given
        BookRequest request = new BookRequest();
        request.setTitle("game of thrones");
        request.setAuthor("george martin");
        request.setPublished(LocalDate.of(2000, 6, 30));

        Book mockBook = new Book();
        mockBook.setId(1L);
        mockBook.setTitle("game of thrones");
        mockBook.setAuthor("george martin");
        mockBook.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setId(1L);
        expected.setTitle("game of thrones");
        expected.setAuthor("george martin");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        when(bookRepository.findByTitle(anyString()))
                .thenReturn(mockBook);
        when(bookMapper.toEntity(any(BookRequest.class)))
                .thenReturn(mockBook);
        when(bookRepository.save(any(Book.class)))
                .thenReturn(mockBook);
        when(bookMapper.toDto(any(Book.class)))
                .thenReturn(expected);

        // when
        BookResponse actual = bookService.save(request);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenExistingBook_whenSave_thenThrowException() {
        // given
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("game of thrones");
        bookRequest.setAuthor("george martin");
        bookRequest.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setId(1L);
        expected.setTitle("game of thrones");
        expected.setAuthor("george martin");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        when(bookRepository.findByTitle(anyString()))
                .thenReturn(null);

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
        Book book = new Book();
        book.setId(1L);
        book.setTitle("game of thrones");
        book.setAuthor("george martin");
        book.setPublished(LocalDate.of(2000, 6, 30));

        Optional<Book> mockBook = Optional.of(book);

        BookResponse mockResponse = new BookResponse();
        mockResponse.setId(2L);
        mockResponse.setTitle("game of thrones2");
        mockResponse.setAuthor("george martin2");
        mockResponse.setPublished(LocalDate.of(2000, 6, 30));

        when(bookRepository.findById(anyLong()))
                .thenReturn(mockBook);
        when(bookMapper.toDto(any(Book.class)))
                .thenReturn(mockResponse);

        // when
        BookResponse actual = bookService.findById(1L);

        assertThat(actual).isEqualTo(mockResponse);
    }

    @Test
    void givenInvalidId_whenFindById_thenThrowException() {
        // define test scenario
        // identify what needs to be mocked
        // objects with methods that are being called

        // given
        // mock objects
        // mock return objects

        // when
        // call method under test

        // then
        // assert

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