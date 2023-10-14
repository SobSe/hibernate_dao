package ru.sobse.hibernate_dao.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Contact implements Serializable {
    @Nonnull
    @Column(length = 60)
    private String name;
    @Nonnull
    @Column(length = 60)
    private String surname;
    private int age;

    public Contact() {
    }

    public Contact(@Nonnull String name, @Nonnull String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }

    @Nonnull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@Nonnull String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return age == contact.age && Objects.equals(name, contact.name) && Objects.equals(surname, contact.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}
