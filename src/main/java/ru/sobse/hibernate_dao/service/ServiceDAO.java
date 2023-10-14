package ru.sobse.hibernate_dao.service;

import org.springframework.stereotype.Service;
import ru.sobse.hibernate_dao.entity.Person;
import ru.sobse.hibernate_dao.repository.RepositoryDAO;

import java.util.List;

@Service
public class ServiceDAO {
    private RepositoryDAO repository;

    public ServiceDAO(RepositoryDAO repository) {
        this.repository = repository;
    }

    public List<Person> personsByCity(String city) {
        return repository.personsByCity(city);
    }
}
