package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.domain.Person;
import com.sda.spring.data.jpa.exception.NotFoundException;
import com.sda.spring.data.jpa.repository.PersonCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrudRepositoryConfig {

    private static final Logger log = LoggerFactory.getLogger(CrudRepositoryConfig.class);

    @Autowired
    public PersonCrudRepository personCrudRepository;

    @Bean
    public CommandLineRunner crudData() {
        return args -> {
            testCrudMethods();
            customFind();
        };
    }

    private void testCrudMethods() {
        // create
        personCrudRepository.save(new Person("ana", 25));
        personCrudRepository.save(new Person("paul", 30));

        // read
        Person paul = personCrudRepository.findByName("paul")
                .orElseThrow(() -> new NotFoundException("person not found"));

        personCrudRepository.findAll()
                .forEach(person -> log.info("person: {}", person));

        boolean existsById = personCrudRepository.existsById(1L);
        log.info("paul exists by id: {}", existsById);

        // update
        paul.setAge(35);
        personCrudRepository.save(paul);

        // delete
        long count = personCrudRepository.count();
        log.info("count before delete: {}", count);

        personCrudRepository.deleteById(paul.getId());

        personCrudRepository.deleteAll();
    }

    private void customFind() {
        log.info("--- in custom find");
        Person person = personCrudRepository.save(new Person("alex", 20));

        Person savedPerson = personCrudRepository.findByName(person.getName())
                .orElseThrow(() -> new NotFoundException("person not found"));
        log.info("found person by name 'alex': {}", savedPerson);
    }
}
