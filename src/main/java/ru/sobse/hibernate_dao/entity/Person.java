package ru.sobse.hibernate_dao.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "persons", schema = "public")
public class Person {

    @EmbeddedId
    private Contact contact;
    @Nonnull
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;
    @Nonnull
    @Column(name = "city_of_living", length = 100)
    private String cityOfLiving;

    public Person() {
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Nonnull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nonnull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nonnull
    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(@Nonnull String city_of_living) {
        this.cityOfLiving = city_of_living;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person persons = (Person) o;
        return Objects.equals(contact, persons.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact);
    }

}
