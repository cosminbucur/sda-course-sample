package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.domain.Person;
import com.sda.spring.data.jpa.repository.PersonCrudRepository;
import com.sda.spring.data.jpa.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonCrudRepository personCrudRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Person jon = new Person("jon", 30);
            personCrudRepository.save(jon);
            Iterable<Person> people = personCrudRepository.findAll();
            people.forEach(person -> log.debug(String.valueOf(person)));
        };
    }
}
