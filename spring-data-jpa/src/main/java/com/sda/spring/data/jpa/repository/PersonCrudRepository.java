package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByName(String name);

}
