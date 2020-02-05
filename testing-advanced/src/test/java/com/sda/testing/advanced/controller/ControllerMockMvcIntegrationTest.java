package com.sda.testing.advanced.controller;

import com.sda.testing.advanced.SpringTestingApplication;
import com.sda.testing.advanced.config.H2TestProfileJPAConfig;
import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {SpringTestingApplication.class, H2TestProfileJPAConfig.class}
)
class ControllerMockMvcIntegrationTest {

    private static final String API_BOOKS = "/books";
    @LocalServerPort
    private static int port = 8083;
    private static final String BASE_URI = "http://localhost:" + port + "/api";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
    }

    @Test
    void givenRequest_whenFindAll_thenReturn200() {
        BookRequest request = new BookRequest();
        request.setTitle("game of thrones");
        request.setAuthor("george martin");
        request.setPublished(LocalDate.of(2000, 6, 30));
        bookService.save(request);

//        mockMvc.perform()

//        assertThat(response.getStatusCode().value()).isEqualTo(200);
//        assertThat(response.getHeaders().get("Content-Type").get(0)).isEqualTo("application/json");
//        assertThat(response.getBody()[0].getTitle()).isEqualTo("game of thrones");
    }

    @Test
    void findById() {
    }

    @Test
    void getBooksByAuthor() {
    }

    @Test
    void update() {
    }

    @Test
    void partialUpdate() {
    }

    @Test
    void delete() {
    }
}