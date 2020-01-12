package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.domain.Person;
import com.sda.spring.data.jpa.repository.PersonPagingAndSortingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Configuration
public class PagingAndSortingRepositoryConfig {

    private static final Logger log = LoggerFactory.getLogger(PagingAndSortingRepositoryConfig.class);

    @Autowired
    public PersonPagingAndSortingRepository personPagingAndSortingRepository;

    @Bean
    public CommandLineRunner pagingAndSortingData() {
        return args -> {
            loadData();
            paginate();
            sort();
            paginateAndSort();
        };
    }

    private void paginateAndSort() {
        Pageable sortedByName = PageRequest.of(0, 5, Sort.by("name"));
        Pageable sortedByAgeDescending = PageRequest.of(0, 4, Sort.by("age").descending());
        Pageable sortedByAgeDescendingAndNameAscending = PageRequest.of(0, 5,
                Sort.by("age").descending()
                        .and(Sort.by("name").ascending()));

        Page<Person> peopleSortedByName = personPagingAndSortingRepository.findAll(sortedByName);
        Page<Person> peopleSortedByAgeDescending = personPagingAndSortingRepository.findAll(sortedByAgeDescending);
        Page<Person> peopleSortedByAgeDescendingAndNameAscending = personPagingAndSortingRepository.findAll(sortedByAgeDescendingAndNameAscending);

        printPageContent(peopleSortedByName);
        printPageContent(peopleSortedByAgeDescending);
        printPageContent(peopleSortedByAgeDescendingAndNameAscending);
    }

    private void sort() {
        Sort sortByName = Sort.by("name");
        Iterable<Person> sortedPeople = personPagingAndSortingRepository.findAll(sortByName);
        sortedPeople.forEach(person -> log.info("person: {}", person));
    }

    private void paginate() {
        // interface pageable - pagination info
        // abstract page request - abstract class
        // page request - implementation class
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        Pageable secondPageWithOneElement = PageRequest.of(1, 1);

        Page<Person> page = personPagingAndSortingRepository.findAll(firstPageWithTwoElements);
        printPageContent(page);

        Page<Person> peopleAge32Page = personPagingAndSortingRepository.findAllByAge(32, firstPageWithTwoElements);
        printPageContent(peopleAge32Page);
    }

    private void printPageContent(Page<Person> page) {
        page.getContent()
                .forEach(person -> log.info("person: {}", person));
    }

    private void loadData() {
        personPagingAndSortingRepository.save(new Person("paul", 32));
        personPagingAndSortingRepository.save(new Person("alina", 28));
        personPagingAndSortingRepository.save(new Person("kazimir", 34));
        personPagingAndSortingRepository.save(new Person("lidia", 32));
        personPagingAndSortingRepository.save(new Person("violeta", 32));
    }
}
