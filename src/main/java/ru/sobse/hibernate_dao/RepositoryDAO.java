package ru.sobse.hibernate_dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.sobse.hibernate_dao.Entity.Persons;

import java.util.List;

@Repository
public class RepositoryDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public RepositoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Persons> personsByCity(String city) {
        String queryText = "select p from Persons p where p.city_of_living = :city";
        List<Persons> persons = entityManager.createQuery(queryText, Persons.class)
                .setParameter("city", city)
                .getResultList();
        return persons;
    }
}
