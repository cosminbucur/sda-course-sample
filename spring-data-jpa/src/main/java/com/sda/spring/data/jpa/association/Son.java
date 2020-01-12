package com.sda.spring.data.jpa.association;

import javax.persistence.*;

@Entity
@Table(name = "son")
public class Son {

    // TODO: simplify this
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
