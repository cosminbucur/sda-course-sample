package com.sda.testing.advanced.controller;

import com.sda.testing.advanced.SpringTestingApplication;
import com.sda.testing.advanced.config.H2TestProfileJPAConfig;
import com.sda.testing.advanced.dto.BookRequest;
import com.sda.testing.advanced.service.BookService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {SpringTestingApplication.class, H2TestProfileJPAConfig.class}
)
class ControllerRestAssuredIntegrationTest {

    private static final String API_BOOKS = "/books";
    @LocalServerPort
    private int port;
    @Autowired
    private BookService bookService;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port + "/api";
        RestAssured.port = port;
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

        given()
                .when()
                .get(API_BOOKS)
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].title", equalTo("game of thrones"));
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