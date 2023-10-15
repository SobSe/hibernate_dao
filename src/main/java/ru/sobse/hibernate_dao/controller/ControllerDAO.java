package ru.sobse.hibernate_dao.controller;

import org.springframework.web.bind.annotation.*;
import ru.sobse.hibernate_dao.entity.Contact;
import ru.sobse.hibernate_dao.entity.Person;
import ru.sobse.hibernate_dao.service.ServiceDAO;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/by-age")
    public List<Person> personByAge(@RequestParam int age) {
        return service.personsByAge(age);
    }

    @GetMapping("/by-name-surname")
    public List<Optional<Person>> personByNameSurname(String name, String surname) {
        return service.personByNameSurname(name, surname);
    }

    @PostMapping("/create")
    public void create(@RequestBody Person person) {
        service.save(person);
    }

    @PostMapping("/update")
    public void update(@RequestBody Person person) {
        service.save(person);
    }

    @PostMapping("/by-id")
    public Person findById(@RequestBody Contact id) {
        return service.findById(id);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Contact id) {
        service.delete(id);
    }
}
