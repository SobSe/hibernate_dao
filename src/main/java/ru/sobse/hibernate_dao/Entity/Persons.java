package ru.sobse.hibernate_dao.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "persons", schema = "public")
public class Persons {

    @EmbeddedId
    private Contact contact;
    @Nonnull
    @Column(length = 11)
    private String phone_number;
    @Nonnull
    @Column(length = 100)
    private String city_of_living;

    public Persons() {
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Nonnull
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(@Nonnull String phone_number) {
        this.phone_number = phone_number;
    }

    @Nonnull
    public String getCity_of_living() {
        return city_of_living;
    }

    public void setCity_of_living(@Nonnull String city_of_living) {
        this.city_of_living = city_of_living;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return Objects.equals(contact, persons.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact);
    }

}
