package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.domain.Person;
import com.sda.spring.data.jpa.repository.PersonCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class IntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(IntegrationTest.class);

    private PersonCrudRepository repository;

    @Autowired
    public IntegrationTest(PersonCrudRepository repository) {
        this.repository = repository;
        testThatDbWorks();
    }

    public void testThatDbWorks() {
        Person person1 = new Person("jon", 30);
        Person person2 = new Person("snow", 31);
        repository.saveAll(Arrays.asList(person1, person2));
        repository.deleteById(1L);
        log.info("repository count: {}", repository.count());
    }
}
