package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.association.Father;
import com.sda.spring.data.jpa.association.FatherRepository;
import com.sda.spring.data.jpa.association.Son;
import com.sda.spring.data.jpa.association.SonRepository;
import com.sda.spring.data.jpa.book.Book;
import com.sda.spring.data.jpa.book.BookRepository;
import com.sda.spring.data.jpa.exception.NotFoundException;
import com.sda.spring.data.jpa.repository.PersonCrudRepository;
import com.sda.spring.data.jpa.repository.PersonRepository;
import com.sda.spring.data.jpa.validation.User;
import com.sda.spring.data.jpa.validation.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Optional;

@Configuration
public class AppConfig {

    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonCrudRepository personCrudRepository;

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private SonRepository sonRepository;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
//            Person jon = new Person("jon", 30);
//            personCrudRepository.save(jon);
//            Iterable<Person> people = personCrudRepository.findAll();
//            people.forEach(person -> log.info("person {}", person));
//
//            Book book = createBook();
//            bookRepository.save(book);
//
//            findBookUsingOptionalGet();
//
//            findBookUsingOptionalOrElseThrow();
//
//            testAssociations();

            testValidations();
        };
    }

    private void testValidations() {
        User user = createUser();
        validateBeforeSave(user);

        User badUser = createBadUser();
        validateBeforeSave(badUser);
    }

    private void validateBeforeSave(User user) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        long violations = validator.validate(user)
                .size();

        if (violations > 0) {
            log.error("user not saved {}", user);
            validator.validate(user)
                    .forEach(violation -> log.error("violation: {}", violation.getMessage()));
        } else {
            userRepository.save(user);
        }
    }

    private User createUser() {
        User user = new User();
        user.setName("jon snow");
        user.setEmail("jonsnow@gmail.com");
        user.setAge(30);
        user.setConsent(true);
        user.setAboutMe("I'm a watcher on the wall");
        return user;
    }

    private User createBadUser() {
        User user = new User();
        user.setName("");
        user.setEmail("jonsnowgmail.com");
        user.setAge(5);
        user.setConsent(false);
        user.setAboutMe("...");
        return user;
    }

    private void testAssociations() {
        Son son1 = new Son();
        son1.setName("son1");

        Son son2 = new Son();
        son2.setName("son2");

        Father father = new Father();
        father.setName("father");

        father.getSons().add(son1);
        father.getSons().add(son2);

        fatherRepository.save(father);
        log.info("father repository size: {}", fatherRepository.count());
        log.info("son repository size: {}", sonRepository.count());
    }

    private void findBookUsingOptionalOrElseThrow() {
        Book foundBook = bookRepository.findById(1L)
                .orElseThrow(() -> new NotFoundException("book not found"));

        log.info("--- saved book: {}", foundBook);
    }

    private Book createBook() {
        Book book = new Book();
        book.setTitle("Game of thrones");
        book.setAuthor("George Martin");
        book.setPublished(LocalDate.now());
        return book;
    }

    private void findBookUsingOptionalGet() {
        // print book from db
        Optional<Book> savedBookOptional =
                bookRepository.findById(1L);

        Book savedBook = null;
        if (savedBookOptional.isPresent()) {
            savedBook = savedBookOptional.get();
        }
        log.info("saved book: {}", savedBook);
    }
}
