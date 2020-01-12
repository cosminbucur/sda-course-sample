package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonPagingAndSortingRepository extends
        PagingAndSortingRepository<Person, Long> {

    Page<Person> findAllByAge(int age, Pageable firstPageWithTwoElements);
}
