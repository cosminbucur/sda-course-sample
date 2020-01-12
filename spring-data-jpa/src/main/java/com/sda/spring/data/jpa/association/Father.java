package com.sda.spring.data.jpa.association;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Father")
@Table(name = "father")
public class Father {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "father_id")
    private List<Son> sons = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Son> getSons() {
        return sons;
    }

    public void setSons(List<Son> sons) {
        this.sons = sons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
