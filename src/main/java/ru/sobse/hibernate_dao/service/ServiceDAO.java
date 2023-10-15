package ru.sobse.hibernate_dao.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.sobse.hibernate_dao.entity.Contact;
import ru.sobse.hibernate_dao.entity.Person;
import ru.sobse.hibernate_dao.repository.RepositoryDAO;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDAO {
    private RepositoryDAO repository;

    public ServiceDAO(RepositoryDAO repository) {
        this.repository = repository;
    }

    public List<Person> personsByCity(String city) {
        return repository.findPersonByCityOfLiving(city);
    }

    public List<Person> personsByAge(int age) {
        return repository.findPersonByContactAgeBeforeOrderByContact(age);
    }

    public List<Optional<Person>> personByNameSurname(String name, String surname) {
        return repository.findPersonByContact_NameAndContact_Surname(name, surname);
    }

    public void save(Person person) {
        repository.save(person);
    }

    public Person findById(Contact id) {
        return repository.findById(id).orElseThrow();
    }

    public void delete(Contact id) {
        repository.deleteById(id);
    }
}
