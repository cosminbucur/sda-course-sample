package com.sda.testing.advanced.dto;

import com.sda.testing.advanced.model.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class BookMapperTest {

    // functional test
    // unit test a simple method
    // create test scenario
    @Test
    void givenEntity_whenToDto_thenReturnDto() {
        BookMapper bookMapper = new BookMapper();

        Book book = new Book();
        book.setId(1L);
        book.setTitle("game of thrones");
        book.setAuthor("geroge martin");
        book.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setId(1L);
        expected.setTitle("game of thrones");
        expected.setAuthor("geroge martin");
        expected.setPublished(LocalDate.of(2000, 6, 30));

        BookResponse actual = bookMapper.toDto(book);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void toEntity() {
    }
}