package ru.sobse.hibernate_dao.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.sobse.hibernate_dao.entity.Person;

import java.util.List;

@Repository
public class RepositoryDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public RepositoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> personsByCity(String city) {
        String queryText = "select p from Person p where p.cityOfLiving = :city";
        List<Person> persons = entityManager.createQuery(queryText, Person.class)
                .setParameter("city", city)
                .getResultList();
        return persons;
    }
}
