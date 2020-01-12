package com.sda.spring.data.jpa.validation;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Email(message = "email invalid format")
    private String email;

    @AssertTrue(message = "consent must be accepted")
    private boolean consent;

    @Size(min = 10, max = 100, message =
            "description should be between 10 - 100 characters")
    private String aboutMe;

    @Min(value = 18, message = "age should be at least 18")
    @Max(value = 80, message = "age should be maximum 80")
    private int age;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConsent() {
        return consent;
    }

    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", consent=" + consent +
                ", aboutMe='" + aboutMe + '\'' +
                ", age=" + age +
                '}';
    }
}
