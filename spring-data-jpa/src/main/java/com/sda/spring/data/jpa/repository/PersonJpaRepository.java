package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {
}
