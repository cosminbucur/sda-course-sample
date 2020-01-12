package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.domain.Person;
import com.sda.spring.data.jpa.repository.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Configuration
public class JpaRepositoryConfig {

    @Autowired
    public PersonJpaRepository personJpaRepository;

    @Bean
    public CommandLineRunner jpaData() {
        return args -> {
            loadData();

            long idOfFirstPerson = personJpaRepository.findAll()
                    .get(0).getId();

            Person existingPerson = personJpaRepository
                    .getOne(idOfFirstPerson);

            Pageable firstTwoElements = PageRequest.of(0, 2);
            Iterable<Person> firstTwoPersons = personJpaRepository.findAll(firstTwoElements);

            personJpaRepository.deleteInBatch(firstTwoPersons);

            personJpaRepository.deleteAllInBatch();
        };
    }

    private void loadData() {
        personJpaRepository.save(new Person("paul", 32));
        personJpaRepository.save(new Person("alina", 28));
        personJpaRepository.save(new Person("kazimir", 34));
        personJpaRepository.save(new Person("lidia", 32));
        personJpaRepository.save(new Person("violeta", 32));
    }
}
