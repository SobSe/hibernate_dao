package ru.sobse.hibernate_dao;

import org.springframework.stereotype.Service;
import ru.sobse.hibernate_dao.Entity.Persons;

import java.util.List;

@Service
public class ServiceDAO {
    private RepositoryDAO repository;

    public ServiceDAO(RepositoryDAO repository) {
        this.repository = repository;
    }

    public List<Persons> personsByCity(String city) {
        return repository.personsByCity(city);
    }
}
