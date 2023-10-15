package ru.sobse.hibernate_dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sobse.hibernate_dao.entity.Contact;
import ru.sobse.hibernate_dao.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface  RepositoryDAO extends JpaRepository<Person, Contact> {
    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> personsByCity(@Param("city") String city);

    @Query("select p from Person p where p.contact.age < :age order by p.contact.surname, p.contact.name, p.contact.age")
    List<Person> personsByAge(@Param("age") int age);

    @Query("select p from Person p where p.contact.name = :name and p.contact.surname = :surname")
    List<Optional<Person>> personByNameSurname(@Param("name") String name, @Param("surname") String surname);
}
