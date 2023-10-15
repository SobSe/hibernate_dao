package ru.sobse.hibernate_dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sobse.hibernate_dao.entity.Contact;
import ru.sobse.hibernate_dao.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface  RepositoryDAO extends JpaRepository<Person, Contact> {
    List<Person> findPersonByCityOfLiving(String city);

    List<Person> findPersonByContactAgeBeforeOrderByContact(int age);

    List<Optional<Person>> findPersonByContact_NameAndContact_Surname(String name, String surname);
}
