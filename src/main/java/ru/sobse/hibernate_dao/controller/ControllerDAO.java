package ru.sobse.hibernate_dao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sobse.hibernate_dao.service.ServiceDAO;
import ru.sobse.hibernate_dao.entity.Person;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class ControllerDAO {
    private ServiceDAO service;

    public ControllerDAO(ServiceDAO service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public List<Person> personsByCity(@RequestParam String city) {
        return service.personsByCity(city);
    }
}
